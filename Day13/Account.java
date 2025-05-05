package Day13;
class Account{
    private String name;
    private double balance;
    Account(String name,double balance){
        this.name=name;
        this.balance=balance;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Account && (((Account)obj).name.equals((this.name)) && ((Account)obj).balance==this.balance)){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String toString(){
        return ""+name+""+balance;
    }
    public static void main(String[] args){
        Account ac1=new Account("anna",5000.50);
        Account ac2=new Account("anna", 5000.50);
        System.out.println(ac1.equals(ac2));
        System.out.println(ac1);
    }
}