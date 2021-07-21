object harvest{

    var month = Array.ofDim[Int](4, 7);


    def findDate(date:Int):Unit = {
        val valueModBy7 : Int = (date%7);

        //lets assume month start with monday

        valueModBy7 match {
            case 0 => print(date + 1 + " of monday \n");
            case 1 => print(date + 1 + " of tuesday \n");
            case 2 => print(date + 1 + " of wednsday \n");
            case 3 => print(date + 1 + " of thursday \n");
            case 4 => print(date + 1 + " of friday \n");
            case 5 => print(date + 1 + " of saturday \n");
            case 6 => print(date + 1 + " of sunday \n");
            case _ => print("something went wrong \n");

        }
    }

    def findMin():Unit = {
        var min : Int;
        var day : Int;
        min = month(0)(0);
        for(w <- 0 until 4){
            for(z <- 0 until 7){
                if(min > month(w)(z)){
                    min = month(w)(z);
                    day = w*4 + z;
                }
            }
        }
        println("Minimum amount : " + max);
        print("the date which got minimum amount : ");
        findDate(day);
    }

    def findMax():Unit = {
        var max : Int;
        var day : Int;
        min = month(0)(0);
        for(w <- 0 until 4){
            for(z <- 0 until 7){
                if( max < month(w)(z)){
                    max = month(w)(z);
                    day = w*4 + z;
                }
            }
        }
        println("Maximum amount : " + min);
        print("the date which got maximum amount : ");
        findDate(day);
    }

    def findAverage(sum: Int):Float = {
        val lnth = month.length * month(0).length;
        println("length of month array " + lnth);
        sum.toFloat / lnth.toFloat;

    }

    def findSumAndPrintAverage():Unit = {
        var sum : Int = 0;
        for(w <- 0 until 4){
            for(z <- 0 until 7){
                sum += month(w)(z);
            }
        }
        println("Sum of amount : " + sum);
        println("Average of amount : " + findAverage(sum));
    }

    def findMedian():Unit = {
        var mArr : Array[Float];
        for(w <- 0 until 4){
            for(z <- 0 until 7){
                mArr(w*4 + z) = month(w)(z).toFloat;
            }
        }
        scala.util.Sorting.quickSort(mArr);
        if(mArr.size % 2 == 1){
            println("Meadian of amount : " + mArr((mArr.size + 1)/2))
        }else{
            println("Meadian of amount : " + (mArr(mArr.size / 2)+ mArr(mArr.size + 2))/2);
        }
    }

    def main(args: Array[String]) = {
     var i : Int = 0;
     var j : Int = 0;
     println("Enter the amount picked :: ")
     while(i < 4){
         while(j < 7){
             print("day : " + i*4 + j + 1);
             print("weight : ");
             month(i)(j) = Scala.io.StdIn.readInt();
         }
     }

     findMax();
     findMin();
     findSumAndPrintAverage();
     findMedian();
   }



}