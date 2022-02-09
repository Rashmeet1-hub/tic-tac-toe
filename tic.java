import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner in= new Scanner(System.in);
        

       System.out.print("Player 1:What's your name?") ;
       String p1=in.nextLine();

       System.out.print("Player 2:What's your name?") ;
       String p2=in.nextLine();


char [][] board=new char[3][3];


for(int i=0;i<3;i++){
    for(int j=0;j<3;j++){
        board[i][j]='-';
    }
}

boolean isPlayer1=true;

boolean gameEnded=false;
while(!gameEnded){

printBoard(board);



char symbol=' ';
if(isPlayer1){
   symbol='x';
}
    else{
        symbol='o';
    }
    if(isPlayer1){
        System.out.print(p1+"'s turn(x)");
    }
        else{
            System.out.print(p2+"'s turn(0)");
        }
    
int row=0;
int col=0;
    while(true){
    System.out.print("Enter the row:(0,1,2)");
     row =in.nextInt();

    System.out.print("Enter the column:(0,1,2)");
     col =in.nextInt();
if(row<0||col<0||row>2||col>2){
    System.out.println("row and column are out of bounds");
}
else if(board[row][col]!='-'){
   System.out.println("place already chosen"); 
}else{
  
    break;
}

    }
    
    board[row][col]=symbol;

    if(hasWon(board)=='x'){

System.out.println(p1+"has won!");
gameEnded=true;
    }
    else if(hasWon(board)=='o'){
        System.out.println(p2+"has won!");
        gameEnded=true;
    }
    else{

if(hasTied(board)){
    System.out.println("Tied");
    gameEnded=true;
}else{

isPlayer1=!isPlayer1;
}
    }
}
printBoard(board);

    }
public static void printBoard(char [][] board){
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            System.out.print(board[i][j]);
}
System.out.println();
    }

}

public static char hasWon(char[][] board){
    //row
    for(int i=0;i<3;i++){
      if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][0]!='-') {
          return board[i][0];
      } 
    }
    //col
    for(int j=0;j<3;j++){
        if(board[0][j]==board[1][j]&&board[1][j]==board[2][j]&&board[j][0]!='-') {
            return board[0][j];
        } 
      }
      //diagonal
      if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]!='-'){
return board[0][0];

      }
      if(board[2][0]==board[1][1]&&board[1][1]==board[0][2]&&board[2][0]!='-'){
        return board[2][0];
        
              }
    
              return '-'; 
}
public static boolean hasTied(char[][] board){
    for(int i=0;i<3;i++){
       for(int j=0;j<3;j++){
           if(board[i][j]=='-'){
               return false;
           }
       } 
    }
    return true;
}
}
