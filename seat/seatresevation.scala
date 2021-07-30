import scala.util.control.Breaks._

object  seatresevation {


    var seat = Array[String].ofDim(4,10)

    def intialSetup():Unit = {
        for(w <- 0 until 4){
            for(z <- 0 until 10){
                seat(w)(z) = "0"
            }
        }
    }

    def freeSeat(currentPosition:String):Unit = {
        for(w <- 0 until 4){
            for(z <- 0 until 10){
                if(seat(w)(z) == currentPosition){
                    seat(w)(z) == "0";
                }
            }
        }
    }

    def checkNumberOfFreeSeat():Int = {
        print("Enter current position ")
        val position : String = scala.io.StdIn.readLine();
        freeSeat(position);
        var count:Int = 0;
        for(w <- 0 until 4){
            for(z <- 0 until 10){
                if(seat(w)(z) == "0")
                count += 1;
            }
        }
        count;
    }

    def reserve(departure : String) : Unit = {
        for(w <- 0 until 4){
            for(z <- 0 until 10){
                if(seat(w)(z) == "0"){
                    seat(w)(z) == departure;
                }
            }
        }

    }

    def reserveSeats():Unit = {
        val count : Int = checkNumberOfFreeSeat();
        var flag : Char = 'y';
        var dep : String;
        println("Number of seats can occur to reserve seats : " + count);

        breakable{
        for(a <- 0 until count){
            println("Enter Y to enter more reservation");
            println("Enter anthing else to Stop");
            flag = scala.io.StdIn.readChar();
            if(flag == 'y' || flag == 'Y'){
                dep = scala.io.StdIn.readLine();
                reserve(dep);
            }
            else{
                break();
            }
            
        }
    }

    }



    def main(args:Array[String]){
        var flag1:Int;
        initialsetup();

        breakable{
        while(True){
            println("Enter number 1 to check number of free seats ");
            println("Enter number 2 to reserve a seat ");

            flag1 = scala.io.stdIn.readInt();

            flag1 match {
                case 1 => println("Number of free seets : " + checkNumberOfFreeSeat());
                case 2 => reserveSeats();
                case _ => break();
            }

        }
        }
    }

}