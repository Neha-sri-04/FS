package Day21;
@FunctionalInterface
interface Greetings{
    void greetings(String s);
}
// class Greeting implements Greetings{
//     public String greetings(String s){
//         return s;
//     }
// }
class Solution{
        public static void main(String[] args){
            Greetings g=message->System.out.println("Hello");
            System.out.println(g.getClass().getName());
    }
} 