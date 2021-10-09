public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    Integer agencia;
    Double saldo;
    Double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, Integer agencia, Double saldo, Double chequeEspecial){
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente(){
        System.out.println("Nome do cliente: " + cliente.nome);
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Número da agência: " + agencia);
        System.out.println("Saldo: " + saldo);
        System.out.println("Limite cheque especial: " + chequeEspecial);
        System.out.println("-----------------------------------");
    }

    public Boolean sacar (Double valor){
        if(valor <= 0){
            System.out.println("Você não pode sacar um valor negativo ou zero.");
            return false;
        }else if (valor > (saldo + chequeEspecial)){
            System.out.println("Valor supera o saldo e o limite do cheque especial");
            return false;
        }else{
            saldo -= valor;
            System.out.println("Operação feita com sucesso!");
            return true;
        }
    }

    public Boolean depositar (Double valor){
        if(valor <= 0){
            System.out.println("Você não pode depositar um valor negativo ou zero.");
            return false;
        }else{
            saldo += valor;
            System.out.println("Operação feita com sucesso!");
            return true;
        }
    }

    public Double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }

    public Boolean transferir(ContaCorrente contaDestino, Double valor){
        if(valor <= 0){
            System.out.println("Você não pode transferir um valor negativo ou zero.");
            return false;
        }else if (valor > (saldo + chequeEspecial)){
            System.out.println("Valor supera o saldo e o limite do cheque especial");
            return false;
        }else{
            saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Operação feita com sucesso!");
            return true;
        }
    }











}
