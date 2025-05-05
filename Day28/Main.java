
interface I1{
    void create();
    void read();
    void update();
    void delete();

}

class FileData implements I1{
    public void create(){
        System.out.println("Created a file");
    }
    public void read(){
        System.out.println("Read the file");
    }
    public void update(){
        System.out.println("Updated the file");
    }
    public void delete(){
        System.out.println("Deleted the file");
    }
}
class SQL implements I1{
    public void create(){
        System.out.println("Created a SQL DB");
    }
    public void read(){
        System.out.println("Read the SQL DB");
    }
    public void update(){
        System.out.println("Updated the SQL DB");
    }
    public void delete(){
        System.out.println("Deleted the SQL DB");
    }
}
class Main{
    public static void main(String[] args){
        I1 obj=new FileData();
        obj.create();
        obj.read();
        obj.delete();
        obj.update();
        obj=new SQL();
        obj.create();
        obj.read();
        obj.delete();
        obj.update();

    }
}