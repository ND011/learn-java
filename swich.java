public class swich {
    public static void main(String[] args) {
        String s="monday";
         String result= "";

         result = switch(s){
            case "Sunday" -> "Happy";
            case "monday" -> "Boring"; 
            case "Tuesday" -> "lazy";
            case "Wednesday" ->"average";
            default -> "please add something else";


        };
        System.out.println(result);
    }
    
}
