package Day30;
class Sorting extends Thread{
    public void run(){
        System.out.println("Sorting");
    }
}
class Searching extends Thread{
    public void run(){
        System.out.println("Searching");
    }
}
class Printing extends Thread{
    public void run(){
        System.out.println("Printing");
    }
}
class Solution{
    public static void main(String[] args){
        Sorting s=new Sorting();
        Searching se=new Searching();
        Printing p=new Printing();
        s.start();
        se.start();
        p.start();
    }
}