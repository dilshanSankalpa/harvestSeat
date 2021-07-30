import scala.util.control.Breaks._

object  seatresevation {

    // Declare seat array containing 40 seats
    var seat: Array[Array[String]] = Array.ofDim[String](4,10)

    // Initialize array
    def intialSetup(): Unit = {
        for(w <- 0 until 4){
            for(z <- 0 until 10){
                seat(w)(z) = "0"
            }
        }
    }


   

    def checkNumberOfFreeSeat():Int = {

        print("Enter current position : ")

        val position : String = scala.io.StdIn.readLine()
        for(w <- 0 until 4){
            for(z <- 0 until 10){
                if(seat(w)(z) == position){
                    seat(w)(z) = "0"
                }
            }
        }
        var count:Int = 0

        for(w <- 0 until 4){
            for(z <- 0 until 10){
                if(seat(w)(z) == "0")
                count += 1;
            }
        }
        count;
    }


    def displaySeats() : Unit = {
        for(w <- 0 until 4){
            for(z <- 0 until 10){
                print(seat(w)(z) + " ");
                }
                println("");
            }
        }

    

    def reserveSeats(): Unit = {
        var count : Int = checkNumberOfFreeSeat();
        var flag : Char = 'y'
        var flag2: Boolean = true;
        println("Number of seats can occur to reserve seats : " + count);

        breakable{
        for(a <- 0 until count){
            println("Enter Y to enter more reservation");
            println("Enter anthing else charector to Stop");
            flag = scala.io.StdIn.readChar();
            if((flag == 'y' || flag == 'Y') && count > 0 ){
                println("Enter the depature ");
                flag2 = true;
                var dep = scala.io.StdIn.readLine();
                for(w <- 0 until 4){
                    for(z <- 0 until 10){
                         if(seat(w)(z) == "0" && flag2){
                            seat(w)(z) = dep;
                            flag2 = false;
                        }
                    }
            }
                count -= 1;
            }
            else{
                break();
            }
            
        }
    }

    }

    def main(args:Array[String]){

        intialSetup();
        breakable{
        while(true){
            println("Enter number 1 to check number of free seats ");
            println("Enter number 2 to reserve a seat ");
            println("Enter number 3 to find seats ")
            println("Enter anything else number to exist ");

            var flag1 = scala.io.StdIn.readInt();

            flag1 match {
                case 1 => println("Number of free seats : " + checkNumberOfFreeSeat());
                case 2 => reserveSeats();
                case 3 => displaySeats();
                case _ => break();
            }

        }
        }
    }

}