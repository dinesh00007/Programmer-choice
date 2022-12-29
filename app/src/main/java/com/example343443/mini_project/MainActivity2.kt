package com.example343443.mini_project

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import com.example343443.mini_project.adapters.languageAdapter
import com.example343443.mini_project.model.languageItem
import kotlinx.android.synthetic.main.activity_questions.*
import java.io.FilterReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class MainActivity2 : AppCompatActivity(), OnCellItemClick  {



var mydow :Long = 0
    private var score:Int=0
    private lateinit var listViewAdapter: ExpendableViewAdapter
    var display:MutableList<String> = ArrayList()
    private lateinit var j_textss:List<String>
    private lateinit var topicList: HashMap<String,List<String>>
    lateinit var adapter: ArrayAdapter<*>
    lateinit var  svSearchView:androidx.appcompat.widget.SearchView

    private var arrayList:ArrayList<languageItem> ? = null

    private var gridView:GridView ? = null

    private var languageAdapter:languageAdapter ? = null



    private var arrayLists:ArrayList<bookitem> ? = null
    private var gridViews: GridView? = null

    private var bookadapter : bookadapter ? = null

    private var questionList:ArrayList<Questiondata>?=null
    private var currenposition:Int=1
    private var selectoption:Int=0

    private var quiztimer:Timer ? = null
    private var totalTimermins = 1
    private var secondes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        showList()



    }


   /* private fun serch()
    {
        var ex=findViewById<ExpandableListView>(R.id.asListView)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, j_textss)

           // ex.adapter = adapter



       /* svSearchView.setOnQueryTextListener(object :  SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (j_textss.contains(query)) {
                    adapter.filter.filter(query)
                } else {
                    Toast.makeText(this@MainActivity2, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {

                      adapter.filter.filter(newText)

                return false
            }
        })*/


    }*/

    fun setcolor(opt:Int,color:Int)
    {
        when(opt)
        {
            1->{
                option1.background= ContextCompat.getDrawable(this,color)
            }
            2->{
                option2.background= ContextCompat.getDrawable(this,color)
            }
            3->{
                option3.background= ContextCompat.getDrawable(this,color)
            }
            4->{
                option4.background= ContextCompat.getDrawable(this,color)
            }
        }
    }


    fun setQuestion()
    {
        val question = questionList!![currenposition-1]
        setoptionstyle()

        progressd.progress=currenposition;
        progressd.max=questionList!!.size
        totalsum.text="${currenposition}"+"/"+"${questionList!!.size}"
        question1.text=question.question
        option1.text=question.option_one
        option2.text=question.option_two
        option3.text=question.option_three
        option4.text=question.option_four

    }

    fun setoptionstyle()
    {
        var optionlist:ArrayList<TextView> = arrayListOf()
        optionlist.add(0,option1)
        optionlist.add(1,option2)
        optionlist.add(2,option3)
        optionlist.add(3,option4)

        for(op in optionlist)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background= ContextCompat.getDrawable(this,R.drawable.quetio_op)
            op.typeface= Typeface.DEFAULT
        }

    }

    fun selectoptionstyle(view:TextView,opt:Int)
    {
        setoptionstyle()
        selectoption=opt
        view.background= ContextCompat.getDrawable(this,R.drawable.boder)
        view.typeface= Typeface.DEFAULT
        view.setTextColor(Color.parseColor("#000000"))
    }











    private fun setdatalist():ArrayList<languageItem>
    {


        var arrayList:ArrayList<languageItem> = ArrayList()
        arrayList.add(languageItem(R.drawable.cl,"C Language"))
        arrayList.add(languageItem(R.drawable.ccc,"C++ Language"))
        arrayList.add(languageItem(R.drawable.javaa,"java Language"))

        arrayList.add(languageItem(R.drawable.pythons,"Python Language"))

        arrayList.add(languageItem(R.drawable.ccsg,"C# Language"))
        arrayList.add(languageItem(R.drawable.mouses,"Mouse Language"))
        arrayList.add(languageItem(R.drawable.unos,"Embedded program Language"))

    return arrayList
    }



    private fun setdatalists():ArrayList<bookitem>
    {


        var arrayLists:ArrayList<bookitem> = ArrayList()
        arrayLists.add(bookitem(R.drawable.cl,"C Language","View "  ))
        arrayLists.add(bookitem(R.drawable.ccc,"C++ Language","View "))
        arrayLists.add(bookitem(R.drawable.javaa,"java Language","View "))

        arrayLists.add(bookitem(R.drawable.pythons,"Python Language","View "))

        arrayLists.add(bookitem(R.drawable.ccsg,"C# Language","View "))

        arrayLists.add(bookitem(R.drawable.unos,"Embedded program Language","View "))
        return arrayLists
    }

    private fun setdatalistmcq():ArrayList<languageItem>
    {


        var arrayList:ArrayList<languageItem> = ArrayList()
        arrayList.add(languageItem(R.drawable.cl,"C Language"))
        arrayList.add(languageItem(R.drawable.ccc,"C++ Language"))
        arrayList.add(languageItem(R.drawable.javaa,"java Language"))

        arrayList.add(languageItem(R.drawable.pythons,"Python Language"))

        return arrayList
    }

    private fun starttime()
    {

        object : CountDownTimer(600000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                times.setText("" + millisUntilFinished/1000)
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                times.setText("Time Over!")
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }
        }.start()



    }




    private fun showList()
    {


        j_textss=ArrayList<String>()
        topicList= HashMap()


          when {
            intent.getStringExtra("data")=="Java programming" -> {

                supportActionBar!!.setTitle("Java programs")



                (j_textss as ArrayList<String>).add("1.Hello world program in Java")
                (j_textss as ArrayList<String>).add("2.Fibonacci Series in Java")
                (j_textss as ArrayList<String>).add("3.Prime Number Program in Java")
                (j_textss as ArrayList<String>).add("4.Palindrome Program in Java")
                (j_textss as ArrayList<String>).add("5.Armstrong Number in Java")
                (j_textss as ArrayList<String>).add("6.Program to copy all elements of one array into  another array")
                (j_textss as ArrayList<String>).add("7.Program to print the smallest element in an array")
                (j_textss as ArrayList<String>).add("8.Java Program to find Second Largest Number in an Array")
                (j_textss as ArrayList<String>).add("9.Java Program to add two matrices")
                (j_textss as ArrayList<String>).add("10.Binary Search in Java")
                (j_textss as ArrayList<String>).add("Interview Questions java")


                var display:MutableList<String> = ArrayList()
                val topic1:MutableList<String> = ArrayList()

                topic1.add("class Simple{  \n" + "    public static void main(String args[]){  \n" + "     System.out.println(\"Hello Java\");  }  } \n \n Output:Hello Java"
                )

                val topic2:MutableList<String> = ArrayList()
                topic2.add("class FibonacciExample1" +
                        "{ \n " +
                        "public static void main(String args[])  " +
                        "{   \n " +
                        " int n1=0,n2=1,n3,i,count=10;    \n" +
                        " System.out.print(n1+\" \"+n2);//printing 0 and 1    \n" +
                        "    \n" +
                        " for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed    " +
                        " {    \n" +
                        "  n3=n1+n2;    \n" +
                        "  System.out.print(\" \"+n3);    \n" +
                        "  n1=n2;    \n" +
                        "  n2=n3;    " +
                        " }    " +
                        "  " +
                        "}} \n \noutput 0 1 1 2 3 5 8 13 21 34")


                val topic3:MutableList<String> = ArrayList()
                topic3.add("public class PrimeExample{    \n" +
                        " public static void main(String args[]){    \n" +
                        "  int i,m=0,flag=0;      \n" +
                        "  int n=3;//it is the number to be checked    \n" +
                        "  m=n/2;      \n" +
                        "  if(n==0||n==1){  \n" +
                        "   System.out.println(n+\" is not prime number\");      " +
                        "  }else{  \n" +
                        "   for(i=2;i<=m;i++){      \n" +
                        "    if(n%i==0){      \n" +
                        "     System.out.println(n+\" is not prime number\");      \n" +
                        "     flag=1;      \n" +
                        "     break;      " +
                        "    }      " +
                        "   }      \n" +
                        "   if(flag==0) \n { System.out.println(n+\" is prime number\"); }  " +
                        "  }  " +
                        "}    " +
                        "}\n\n output 3 is prime number ")

                val topic4:MutableList<String> = ArrayList()
                topic4.add("class PalindromeExample{  \n" +
                        " public static void main(String args[]){  \n" +
                        "  int r,sum=0,temp;    \n" +
                        "  int n=454;//It is the number variable to be checked for palindrome  \n" +
                        "  \n" +
                        "  temp=n;    \n" +
                        "  while(n>0){    \n" +
                        "   r=n%10;  //getting remainder  \n" +
                        "   sum=(sum*10)+r;    \n" +
                        "   n=n/10;    " +
                        "  }    \n" +
                        "  if(temp==sum)    \n" +
                        "   System.out.println(\"palindrome number \");    \n" +
                        "  else    \n" +
                        "   System.out.println(\"not palindrome\");    " +
                        "}  " +
                        "}")

                val topic5:MutableList<String> = ArrayList()
                topic5.add("class ArmstrongExample{  \n" +
                        "  public static void main(String[] args)  {  \n" +
                        "    int c=0,a,temp;  \n" +
                        "    int n=153;//It is the number to check armstrong  \n" +
                        "    temp=n;  \n" +
                        "    while(n>0)  " +
                        "    {  \n" +
                        "    a=n%10;  \n" +
                        "    n=n/10;  \n" +
                        "    c=c+(a*a*a);  " +
                        "    }  \n" +
                        "    if(temp==c)  \n" +
                        "    System.out.println(\"armstrong number\");   \n" +
                        "    else  \n" +
                        "        System.out.println(\"Not armstrong number\");   " +
                        "   }  " +
                        "}\n output \n armstrong number")

                val topic6:MutableList<String> = ArrayList()
                topic6.add("public class CopyArray {    \n" +
                        "    public static void main(String[] args) {        \n" +
                        "             //Initialize array     \n" +
                        "        int [] arr1 = new int [] {1, 2, 3, 4, 5};     \n" +
                        "         //Create another array arr2 with size of arr1    \n" +
                        "        int arr2[] = new int[arr1.length];    \n" +
                        "        //Copying all elements of one array into another    \n" +
                        "        for (int i = 0; i < arr1.length; i++) {     \n" +
                        "            arr2[i] = arr1[i];     " +
                        "        }      \n" +
                        "         //Displaying elements of array arr1     \n" +
                        "        System.out.println(\"Elements of original array: \");    \n" +
                        "        for (int i = 0; i < arr1.length; i++) {     \n" +
                        "           System.out.print(arr1[i] + \" \");    " +
                        "        }     \n" +
                        "            \n" +
                        "        System.out.println();    \n" +
                        "            \n" +
                        "        //Displaying elements of array arr2     \n" +
                        "        System.out.println(\"Elements of new array: \");    \n" +
                        "        for (int i = 0; i < arr2.length; i++) {     \n" +
                        "           System.out.print(arr2[i] + \" \");    " +
                        "        }     " +
                        "    }    " +
                        "} \n output\n Elements of original array:" +
                        "1 2 3 4 5\n" +
                        "Elements of new array:" +
                        "1 2 3 4 5")

                val topic7:MutableList<String> = ArrayList()
                topic7.add("public class SmallestElement_array {  \n" +
                        "    public static void main(String[] args) {  \n" +
                        "  \n" +
                        "        //Initialize array  \n" +
                        "        int [] arr = new int [] {25, 11, 7, 75, 56};  \n" +
                        "        //Initialize min with first element of array.  \n" +
                        "        int min = arr[0];  \n" +
                        "        //Loop through the array  \n" +
                        "        for (int i = 0; i < arr.length; i++) {  \n" +
                        "            //Compare elements of array with min  \n" +
                        "           if(arr[i] <min)  \n" +
                        "               min = arr[i];  " +
                        "        }  \n" +
                        "        System.out.println(\"Smallest element present in given array: \" + min);  " +
                        "    }  " +
                        "} \noutput \nSmallest element present in given array: 7")

                val topic8:MutableList<String> = ArrayList()
                topic8.add("public class SecondLargestInArrayExample{  \n" +
                        "public static int getSecondLargest(int[] a, int total){  \n" +
                        "int temp;  \n" +
                        "for (int i = 0; i < total; i++)   " +
                        "        {  \n" +
                        "            for (int j = i + 1; j < total; j++)   " +
                        "            {  \n" +
                        "                if (a[i] > a[j])   " +
                        "                {  \n" +
                        "                    temp = a[i];  \n" +
                        "                    a[i] = a[j];  \n" +
                        "                    a[j] = temp;  " +
                        "                }  " +
                        "            }  " +
                        "        }  " +
                        "       return a[total-2];  " +
                        "}  \n" +
                        "public static void main(String args[]){  \n" +
                        "int a[]={1,2,5,6,3,2};  \n" +
                        "int b[]={44,66,99,77,33,22,55};  \n" +
                        "System.out.println(\"Second Largest: \"+getSecondLargest(a,6));  \n" +
                        "System.out.println(\"Second Largest: \"+getSecondLargest(b,7));  " +
                        "}} \n output \n Second Largest: 5\n" +
                        "Second Largest: 77")

                val topic9:MutableList<String> = ArrayList()
                topic9.add("public class MatrixAdditionExample{  \n" +
                        "public static void main(String args[]){  \n" +
                        "//creating two matrices    \n" +
                        "int a[][]={{1,3,4},{2,4,3},{3,4,5}};    \n" +
                        "int b[][]={{1,3,4},{2,4,3},{1,2,4}};    \n" +
                        "    \n" +
                        "//creating another matrix to store the sum of two matrices    \n" +
                        "int c[][]=new int[3][3];  //3 rows and 3 columns  \n" +
                        "    \n" +
                        "//adding and printing addition of 2 matrices    \n" +
                        "for(int i=0;i<3;i++){    \n" +
                        "for(int j=0;j<3;j++){    \n" +
                        "c[i][j]=a[i][j]+b[i][j];    //use - for subtraction  \n" +
                        "System.out.print(c[i][j]+\" \");    " +
                        "}    \n" +
                        "System.out.println();//new line    " +
                        "}    " +
                        "}}\n output : 2 6 8" +
                        ",4 8 6" +
                        ",4 6 9 ")

                val topic10:MutableList<String> = ArrayList()
                topic10.add("class BinarySearchExample{  \n" +
                        " public static void binarySearch(int arr[], int first, int last, int key){  \n" +
                        "   int mid = (first + last)/2;  \n" +
                        "   while( first <= last ){  \n" +
                        "      if ( arr[mid] < key ){  \n" +
                        "        first = mid + 1;     " +
                        "      }\nelse if ( arr[mid] == key ){  \n" +
                        "        System.out.println(\"Element is found at index: \" + mid);  \n" +
                        "        break;  " +
                        "      }\n else{  \n" +
                        "         last = mid - 1;  " +
                        "      }  \n" +
                        "      mid = (first + last)/2;  " +
                        "   }  \n" +
                        "   if ( first > last ){  \n" +
                        "      System.out.println(\"Element is not found!\");  " +
                        "   }  " +
                        " }  \n" +
                        " public static void main(String args[]){  \n" +
                        "        int arr[] = {10,20,30,40,50};  \n" +
                        "        int key = 30;  \n" +
                        "        int last=arr.length-1;  \n" +
                        "        binarySearch(arr,0,last,key);     " +
                        " }  " +
                        "}  \n output\nElement is found at index: 2")

                val topic11:MutableList<String> = ArrayList()
                topic11.add("1) What is Java?\n\n" +
                        "Java is the high-level, object-oriented, robust, secure programming language, platform-independent, high performance, Multithreaded, and portable programming language. It was developed by James Gosling in June 1991. It can also be known as the platform as it provides its own JRE and API \n \n\n 2) List the features of Java Programming language.\n\n" +
                        "There are the following features in Java Programming Language.\n" +
                        "\n" +
                        "Simple: Java is easy to learn. The syntax of Java is based on C++ which makes easier to write the program in it.\n" +
                        "\n" +
                        "Object-Oriented: Java follows the object-oriented paradigm which allows us to maintain our code as the combination of different type of objects that incorporates both data and behavior.\n" +
                        "\n" +
                        "Portable: Java supports read-once-write-anywhere approach. We can execute the Java program on every machine. Java program (.java) is converted to bytecode (.class) which can be easily run on every machine.\n" +
                        "\n" +
                        "Platform Independent: Java is a platform independent programming language. It is different from other programming languages like C and C++ which needs a platform to be executed. Java comes with its platform on which its code is executed. Java doesn't depend upon the operating system to be executed.\n" +
                        "\n" +
                        "Secured: Java is secured because it doesn't use explicit pointers. Java also provides the concept of ByteCode and Exception handling which makes it more secured.\n" +
                        "\n" +
                        "Robust: Java is a strong programming language as it uses strong memory management. The concepts like Automatic garbage collection, Exception handling, etc. make it more robust.\n" +
                        "\n" +
                        "Architecture Neutral: Java is architectural neutral as it is not dependent on the architecture. In C, the size of data types may vary according to the architecture (32 bit or 64 bit) which doesn't exist in Java.\n" +
                        "\n" +
                        "Interpreted: Java uses the Just-in-time (JIT) interpreter along with the compiler for the program execution.\n" +
                        "\n" +
                        "High Performance: Java is faster than other traditional interpreted programming languages because Java bytecode is \"close\" to native code. It is still a little bit slower than a compiled language (e.g., C++).\n" +
                        "\n" +
                        "Multithreaded: We can write Java programs that deal with many tasks at once by defining multiple threads. The main advantage of multi-threading is that it doesn't occupy memory for each thread. It shares a common memory area. Threads are important for multi-media, Web applications, etc.\n" +
                        "\n" +
                        "Distributed: Java is distributed because it facilitates users to create distributed applications in Java. RMI and EJB are used for creating distributed applications. This feature of Java makes us able to access files by calling the methods from any machine on the internet.\n" +
                        "\n" +
                        "Dynamic: Java is a dynamic language. It supports dynamic loading of classes. It means classes are loaded on demand. It also supports functions from its native languages, i.e., C and C++.\n\n 3) What do you understand by Java virtual machine?\n\n" +
                        "Java Virtual Machine is a virtual machine that enables the computer to run the Java program. JVM acts like a run-time engine which calls the main method present in the Java code. JVM is the specification which must be implemented in the computer system. The Java code is compiled by JVM to be a Bytecode which is machine independent and close to the native code.\n\n4) What is the difference between JDK, JRE, and JVM?\n\n" +
                        "JVM\n" +
                        "JVM is an acronym for Java Virtual Machine; it is an abstract machine which provides the runtime environment in which Java bytecode can be executed. It is a specification which specifies the working of Java Virtual Machine. Its implementation has been provided by Oracle and other companies. Its implementation is known as JRE.\n" +
                        "\n" +
                        "JVMs are available for many hardware and software platforms (so JVM is platform dependent). It is a runtime instance which is created when we run the Java class. There are three notions of the JVM: specification, implementation, and instance.\n" +
                        "\n" +
                        "JRE\n" +
                        "JRE stands for Java Runtime Environment. It is the implementation of JVM. The Java Runtime Environment is a set of software tools which are used for developing Java applications. It is used to provide the runtime environment. It is the implementation of JVM. It physically exists. It contains a set of libraries + other files that JVM uses at runtime.\n" +
                        "\n" +
                        "JDK\n" +
                        "JDK is an acronym for Java Development Kit. It is a software development environment which is used to develop Java applications and applets. It physically exists. It contains JRE + development tools. JDK is an implementation of any one of the below given Java Platforms released by Oracle Corporation:\n" +
                        "\n" +
                        "Standard Edition Java Platform\n" +
                        "Enterprise Edition Java Platform\n" +
                        "Micro Edition Java Platform \n \n 5) What is JIT compiler?\n\n" +
                        "Just-In-Time(JIT) compiler: It is used to improve the performance. JIT compiles parts of the bytecode that have similar functionality at the same time, and hence reduces the amount of time needed for compilation. Here the term “compiler” refers to a translator from the instruction set of a Java virtual machine (JVM) to the instruction set of a specific CPU.")


                topicList[j_textss[0]]=topic1
                topicList[j_textss[1]]=topic2
                topicList[j_textss[2]]=topic3
                topicList[j_textss[3]]=topic4
                topicList[j_textss[4]]=topic5
                topicList[j_textss[5]]=topic6
                topicList[j_textss[6]]=topic7
                topicList[j_textss[7]]=topic8
                topicList[j_textss[8]]=topic9
                topicList[j_textss[9]]=topic10
                topicList[j_textss[10]]=topic11
                display.addAll(j_textss)


                listViewAdapter = ExpendableViewAdapter(this, j_textss, topicList)
                val recycle = findViewById<ExpandableListView>(R.id.asListView)

                recycle.setAdapter(listViewAdapter)



            }
            intent.getStringExtra("data")=="C programming" -> {

                supportActionBar!!.setTitle("C Programs")

                (j_textss as ArrayList<String>).add("1.Program to Display Hello, World!")
                (j_textss as ArrayList<String>).add("2.Program to Print an Integer")
                (j_textss as ArrayList<String>).add("3.Program to Add Two Integers")
                (j_textss as ArrayList<String>).add("4.Program to Multiply Two Numbers")
                (j_textss as ArrayList<String>).add("5.Program to Compute Quotient and Remainder")
                (j_textss as ArrayList<String>).add("6.Using if...else Ladder")
                (j_textss as ArrayList<String>).add("7.Program to Find the Size of Variables")
                (j_textss as ArrayList<String>).add("8.Program Using the long keyword")
                (j_textss as ArrayList<String>).add("9.Swap Numbers Using Temporary Variable")
                (j_textss as ArrayList<String>).add("10.Program to Check Even or Odd")
                (j_textss as ArrayList<String>).add("Interview Questions C ")










                val topic1:MutableList<String> = ArrayList()
                topic1.add("#include <stdio.h>\n" +
                        "int main() {\n" +
                        "   // printf() displays the string inside quotation\n" +
                        "   printf(\"Hello, World!\");\n" +
                        "   return 0;" +
                        "}\n" +
                        "Output\n" +
                        "\n" +
                        "Hello, World!")

                val topic2:MutableList<String> = ArrayList()
                topic2.add("#include <stdio.h>\n" +
                        "int main() {   \n" +
                        "    int number;\n" +
                        "   \n" +
                        "    printf(\"Enter an integer: \");  \n" +
                        "    \n" +
                        "    // reads and stores input\n" +
                        "    scanf(\"%d\", &number);\n" +
                        "\n" +
                        "    // displays output\n" +
                        "    printf(\"You entered: %d\", number);\n" +
                        "    \n" +
                        "    return 0;" +
                        "}\n" +
                        "Output\n" +
                        "\n" +
                        "Enter an integer: 25\n" +
                        "You entered: 25")


                val topic3:MutableList<String> = ArrayList()
                topic3.add("#include <stdio.h>\n" +
                        "int main() {    \n" +
                        "\n" +
                        "    int number1, number2, sum;\n" +
                        "    \n" +
                        "    printf(\"Enter two integers: \");\n" +
                        "    scanf(\"%d %d\", &number1, &number2);\n" +
                        "\n" +
                        "    // calculating sum\n" +
                        "    sum = number1 + number2;      \n" +
                        "    \n" +
                        "    printf(\"%d + %d = %d\", number1, number2, sum);\n" +
                        "    return 0;" +
                        "}\n" +
                        "Output\n" +
                        "\n" +
                        "Enter two integers: 12" +
                        "11:" +
                        "12 + 11 = 23")

                val topic4:MutableList<String> = ArrayList()
                topic4.add("#include <stdio.h>\n" +
                        "int main() {\n" +
                        "    double a, b, product;\n" +
                        "    printf(\"Enter two numbers: \");\n" +
                        "    scanf(\"%lf %lf\", &a, &b);  \n" +
                        " \n" +
                        "    // Calculating product\n" +
                        "    product = a * b;\n" +
                        "\n" +
                        "    // Result up to 2 decimal point is displayed using %.2lf\n" +
                        "    printf(\"Product = %.2lf\", product);\n" +
                        "    \n" +
                        "    return 0;" +
                        "}\n" +
                        "Output\n" +
                        "\n" +
                        "Enter two numbers: 2.4\n" +
                        "n 1.12\n" +
                        "Product = 2.69")

                val topic5:MutableList<String> = ArrayList()
                topic5.add("#include <stdio.h>\n" +
                        "int main() {\n" +
                        "    int dividend, divisor, quotient, remainder;\n" +
                        "    printf(\"Enter dividend: \");\n" +
                        "    scanf(\"%d\", &dividend);\n" +
                        "    printf(\"Enter divisor: \");\n" +
                        "    scanf(\"%d\", &divisor);\n" +
                        "\n" +
                        "    // Computes quotient\n" +
                        "    quotient = dividend / divisor;\n" +
                        "\n" +
                        "    // Computes remainder\n" +
                        "    remainder = dividend % divisor;\n" +
                        "\n" +
                        "    printf(\"Quotient = %d\\n\", quotient);\n" +
                        "    printf(\"Remainder = %d\", remainder);\n" +
                        "    return 0;" +
                        "}\n" +
                        "Output\n" +
                        "\n" +
                        "Enter dividend: 25\n" +
                        "Enter divisor: 4\n" +
                        "Quotient = 6\n" +
                        "Remainder = 1 ")

                val topic6:MutableList<String> = ArrayList()
                topic6.add("#include <stdio.h>\n" +
                        "int main() {\n" +
                        "    double n1, n2, n3;\n" +
                        "    printf(\"Enter three numbers: \");\n" +
                        "    scanf(\"%lf %lf %lf\", &n1, &n2, &n3);\n" +
                        "\n" +
                        "    // if n1 is greater than both n2 and n3, n1 is the largest\n" +
                        "    if (n1 >= n2 && n1 >= n3)\n" +
                        "        printf(\"%.2lf is the largest number.\", n1);\n" +
                        "\n" +
                        "    // if n2 is greater than both n1 and n3, n2 is the largest\n" +
                        "    else if (n2 >= n1 && n2 >= n3)\n" +
                        "        printf(\"%.2lf is the largest number.\", n2);\n" +
                        "\n" +
                        "    // if both above conditions are false, n3 is the largest\n" +
                        "    else\n" +
                        "        printf(\"%.2lf is the largest number.\", n3);\n" +
                        "\n" +
                        "    return 0;\n" +
                        "}")

                val topic7:MutableList<String> = ArrayList()
                topic7.add("#include<stdio.h>\n" +
                        "int main() {\n" +
                        "    int intType;\n" +
                        "    float floatType;\n" +
                        "    double doubleType;\n" +
                        "    char charType;\n" +
                        "\n" +
                        "    // sizeof evaluates the size of a variable\n" +
                        "    printf(\"Size of int: %zu bytes\\n\", sizeof(intType));\n" +
                        "    printf(\"Size of float: %zu bytes\\n\", sizeof(floatType));\n" +
                        "    printf(\"Size of double: %zu bytes\\n\", sizeof(doubleType));\n" +
                        "    printf(\"Size of char: %zu byte\\n\", sizeof(charType));\n" +
                        "    \n" +
                        "    return 0;" +
                        "}\n" +
                        "Output\n" +
                        "\n" +
                        "Size of int: 4 bytes\n" +
                        "Size of float: 4 bytes\n" +
                        "Size of double: 8 bytes\n" +
                        "Size of char: 1 byte")

                val topic8:MutableList<String> = ArrayList()
                topic8.add("#include <stdio.h>\n" +
                        "int main() {\n" +
                        "    int a;\n" +
                        "    long b;   // equivalent to long int b;\n" +
                        "    long long c;  // equivalent to long long int c;\n" +
                        "    double e;\n" +
                        "    long double f;\n" +
                        "\n" +
                        "    printf(\"Size of int = %zu bytes \\n\", sizeof(a));\n" +
                        "    printf(\"Size of long int = %zu bytes\\n\", sizeof(b));\n" +
                        "    printf(\"Size of long long int = %zu bytes\\n\", sizeof(c));\n" +
                        "    printf(\"Size of double = %zu bytes\\n\", sizeof(e));\n" +
                        "    printf(\"Size of long double = %zu bytes\\n\", sizeof(f));\n" +
                        "    \n" +
                        "    return 0;" +
                        "}\n" +
                        "Output\n" +
                        "\n" +
                        "Size of int = 4 bytes \n" +
                        "Size of long int = 8 bytes\n" +
                        "Size of long long int = 8 bytes\n" +
                        "Size of double = 8 bytes\n" +
                        "Size of long double = 16 bytes")

                val topic9:MutableList<String> = ArrayList()
                topic9.add("#include<stdio.h>\n" +
                        "int main() {\n" +
                        "      double first, second, temp;\n" +
                        "      printf(\"Enter first number: \");\n" +
                        "      scanf(\"%lf\", &first);\n" +
                        "      printf(\"Enter second number: \");\n" +
                        "      scanf(\"%lf\", &second);\n" +
                        "\n" +
                        "      // Value of first is assigned to temp\n" +
                        "      temp = first;\n" +
                        "\n" +
                        "      // Value of second is assigned to first\n" +
                        "      first = second;\n" +
                        "\n" +
                        "      // Value of temp (initial value of first) is assigned to second\n" +
                        "      second = temp;\n" +
                        "\n" +
                        "      printf(\"\\nAfter swapping, firstNumber = %.2lf\\n\", first);\n" +
                        "      printf(\"After swapping, secondNumber = %.2lf\", second);\n" +
                        "      return 0;" +
                        "}\n" +
                        "\n" +
                        "Output\n" +
                        "\n" +
                        "Enter first number: 1.20\n" +
                        "Enter second number: 2.45\n" +
                        "\n" +
                        "After swapping, firstNumber = 2.45\n" +
                        "After swapping, secondNumber = 1.20")

                val topic10:MutableList<String> = ArrayList()
                topic10.add("#include <stdio.h>\n" +
                        "int main() {\n" +
                        "    int num;\n" +
                        "    printf(\"Enter an integer: \");\n" +
                        "    scanf(\"%d\", &num);\n" +
                        "\n" +
                        "    // True if num is perfectly divisible by 2\n" +
                        "    if(num % 2 == 0)\n" +
                        "        printf(\"%d is even.\", num);\n" +
                        "    else\n" +
                        "        printf(\"%d is odd.\", num);\n" +
                        "    \n" +
                        "    return 0;" +
                        "}\n" +
                        "Output\n" +
                        "\n" +
                        "Enter an integer: -7\n" +
                        "-7 is odd.")

                val topic11:MutableList<String> = ArrayList()
                topic11.add("1) What is a pointer?\n\n" +
                        "A pointer is a special variable, which stores the memory address. The ‘ampersand’ denoted by ‘&’ and the ‘dereferencing’ factor denoted by ‘*’ are the necessities of pointers. Ampersand in front of a variable gets its address and asterisk in front of a pointer gets its value.\n\n2) What is null pointer?\n\n" +
                        "Null pointer is a pointer which cannot point to anywhere in the program, but uninitialised pointer can point to anywhere in the users program. In C, if the pointer tried to access 0th location, operating system kills the running program because operating system does not allow to access 0th value.\n\n3) Define function pointer?\n\n" +
                        "The function pointer is the pointer which accesses the address of a function. The running program occupies some memory space. Both the executable compiled program code and as well as user variables works on function pointers.\n" +
                        "In the C, each function has an address in a code segment.\n\n4) What is volatile variable?\n\n" +
                        "Volatile variables are those variables which alters the default way of the program.\n" +
                        "The variable which do not change while compiling but are changeable during execution.\n\n5)  Difference between global and static variable?\n\n" +
                        "Static variables persist throughout the scope, but the lifespan is not throughout the program. Global variables persist throughout the scope of base blocks of memory that is their lifespan is throughout the program.\n" +
                        "\n" +
                        "6)  What are the files automatically opened when C file is executed?\n\n" +
                        "Standard in, standard out, standard error (stdin, stdout, stderr) are the files which are automatically opened when C file is executed.\n" +
                        "\n" +
                        "7) Compare between array and pointer.\n\n" +
                        "Array can allocate variables but cannot reallocate those variable if required.  Whereas the pointer was assigned to allocate variables and they can also relocate and also are resizable\n\n8) Define function prototype?\n\n" +
                        "The function prototype is the prototype which depends on the following:\n" +
                        "a. No. of input types\n" +
                        "b. No. of outputs which are to be returned\n" +
                        "\n" +
                        "9) Where the function pointers can be used?\n\n" +
                        "The function  pointers can be used when if/switch statements are present,in late binding(variation tables) and to implement call backs activities.\n" +
                        "\n" +
                        "10) What do you mean by #include<stdio.h>?\n\n" +
                        "In C, the hash function # tells the compiler that a statement should be sent to the C preprocessor. The include looks after the new files and replace the contents of those files. and stdio.h will be valid only for the printf, scanf functions.")

                topicList[j_textss[0]]=topic1
                topicList[j_textss[1]]=topic2
                topicList[j_textss[2]]=topic3
                topicList[j_textss[3]]=topic4
                topicList[j_textss[4]]=topic5
                topicList[j_textss[5]]=topic6
                topicList[j_textss[6]]=topic7
                topicList[j_textss[7]]=topic8
                topicList[j_textss[8]]=topic9
                topicList[j_textss[9]]=topic10
                topicList[j_textss[10]]=topic11
                display.addAll(j_textss)


                listViewAdapter = ExpendableViewAdapter(this, j_textss, topicList)
                val recycle = findViewById<ExpandableListView>(R.id.asListView)

                recycle.setAdapter(listViewAdapter)





            }
            intent.getStringExtra("data")=="Python programming" -> {

                supportActionBar!!.setTitle("Python Programs")

                (j_textss as ArrayList<String>).add("1.This program prints Hello, world! in Python")
                (j_textss as ArrayList<String>).add("2.Add Two Numbers in python")
                (j_textss as ArrayList<String>).add("3.For positive numbers")
                (j_textss as ArrayList<String>).add("4.Python Program to find the area of triangle")
                (j_textss as ArrayList<String>).add("5.Solve the quadratic equation ax**2 + bx + c = 0")
                (j_textss as ArrayList<String>).add("6.Python program to swap two variables")
                (j_textss as ArrayList<String>).add("7.Program to generate a random number between 0 and 9")
                (j_textss as ArrayList<String>).add("8.Kilometers to Miles")
                (j_textss as ArrayList<String>).add("9.Using Nested if")
                (j_textss as ArrayList<String>).add("10.Python Program to convert temperature in celsius to fahrenheit")
                (j_textss as ArrayList<String>).add("Interview Questions Python")
                display.addAll(j_textss)
                val topic1:MutableList<String> = ArrayList()
                topic1.add("\n" +
                        "print('Hello, world!')\n" +
                        "\n" +
                        "Output\n" +
                        "\n" +
                        "Hello, world!")

                val topic2:MutableList<String> = ArrayList()
                topic2.add("num1 = 1.5\n" +
                        "num2 = 6.3\n" +
                        "\n" +
                        "# Add two numbers\n" +
                        "sum = num1 + num2\n" +
                        "\n" +
                        "# Display the sum\n" +
                        "print('The sum of {0} and {1} is {2}'.format(num1, num2, sum))\n" +
                        "Output\n" +
                        "\n" +
                        "The sum of 1.5 and 6.3 is 7.8\n")


                val topic3:MutableList<String> = ArrayList()
                topic3.add("num = 8 \n" +
                        "\n" +
                        "# To take the input from the user\n" +
                        "#num = float(input('Enter a number: '))\n" +
                        "\n" +
                        "num_sqrt = num ** 0.5\n" +
                        "print('The square root of %0.3f is %0.3f'%(num ,num_sqrt))\n" +
                        "Output\n" +
                        "\n" +
                        "The square root of 8.000 is 2.828")

                val topic4:MutableList<String> = ArrayList()
                topic4.add("a = 5\n" +
                        "b = 6\n" +
                        "c = 7\n" +
                        "\n" +
                        "# Uncomment below to take inputs from the user\n" +
                        "# a = float(input('Enter first side: '))\n" +
                        "# b = float(input('Enter second side: '))\n" +
                        "# c = float(input('Enter third side: '))\n" +
                        "\n" +
                        "# calculate the semi-perimeter\n" +
                        "s = (a + b + c) / 2\n" +
                        "\n" +
                        "# calculate the area\n" +
                        "area = (s*(s-a)*(s-b)*(s-c)) ** 0.5\n" +
                        "print('The area of the triangle is %0.2f' %area)\n" +
                        "Output\n" +
                        "\n" +
                        "The area of the triangle is 14.70")

                val topic5:MutableList<String> = ArrayList()
                topic5.add("# import complex math module\n" +
                        "import cmath\n" +
                        "\n" +
                        "a = 1\n" +
                        "b = 5\n" +
                        "c = 6\n" +
                        "\n" +
                        "# calculate the discriminant\n" +
                        "d = (b**2) - (4*a*c)\n" +
                        "\n" +
                        "# find two solutions\n" +
                        "sol1 = (-b-cmath.sqrt(d))/(2*a)\n" +
                        "sol2 = (-b+cmath.sqrt(d))/(2*a)\n" +
                        "\n" +
                        "print('The solution are {0} and {1}'.format(sol1,sol2))\n" +
                        "Output\n" +
                        "\n" +
                        "Enter a: 1\n" +
                        "Enter b: 5\n" +
                        "Enter c: 6\n" +
                        "The solutions are (-3+0j) and (-2+0j) ")

                val topic6:MutableList<String> = ArrayList()
                topic6.add("x = 5\n" +
                        "y = 10\n" +
                        "\n" +
                        "# To take inputs from the user\n" +
                        "#x = input('Enter value of x: ')\n" +
                        "#y = input('Enter value of y: ')\n" +
                        "\n" +
                        "# create a temporary variable and swap the values\n" +
                        "temp = x\n" +
                        "x = y\n" +
                        "y = temp\n" +
                        "\n" +
                        "print('The value of x after swapping: {}'.format(x))\n" +
                        "print('The value of y after swapping: {}'.format(y))\n" +
                        "Output\n" +
                        "\n" +
                        "The value of x after swapping: 10\n" +
                        "The value of y after swapping: 5")

                val topic7:MutableList<String> = ArrayList()
                topic7.add("# importing the random module\n" +
                        "import random\n" +
                        "\n" +
                        "print(random.randint(0,9))\n" +
                        "Output\n" +
                        "\n" +
                        "no:5")

                val topic8:MutableList<String> = ArrayList()
                topic8.add("kilometers = float(input(\"Enter value in kilometers: \"))\n" +
                        "\n" +
                        "# conversion factor\n" +
                        "conv_fac = 0.621371\n" +
                        "\n" +
                        "# calculate miles\n" +
                        "miles = kilometers * conv_fac\n" +
                        "print('%0.2f kilometers is equal to %0.2f miles' %(kilometers,miles))\n" +
                        "Output\n" +
                        "\n" +
                        "Enter value in kilometers: 3.5\n" +
                        "3.50 kilometers is equal to 2.17 miles\n")

                val topic9:MutableList<String> = ArrayList()
                topic9.add("Using Nested if\n" +
                        "num = float(input(\"Enter a number: \"))\n" +
                        "if num >= 0:\n" +
                        "   if num == 0:\n" +
                        "       print(\"Zero\")\n" +
                        "   else:\n" +
                        "       print(\"Positive number\")\n" +
                        "else:\n" +
                        "   print(\"Negative number\")\n" +
                        "Output \n" +
                        "\n" +
                        "Enter a number: 0\n" +
                        "Zero")

                val topic10:MutableList<String> = ArrayList()
                topic10.add("# change this value for a different result\n" +
                        "celsius = 37.5\n" +
                        "\n" +
                        "# calculate fahrenheit\n" +
                        "fahrenheit = (celsius * 1.8) + 32\n" +
                        "print('%0.1f degree Celsius is equal to %0.1f degree Fahrenheit' %(celsius,fahrenheit))\n" +
                        "Output\n" +
                        "\n" +
                        "37.5 degree Celsius is equal to 99.5 degree Fahrenheit\n")

                val topic11:MutableList<String> = ArrayList()
                topic11.add("1) What is Python? What are the benefits of using Python?\n\n" +
                        "\n" +
                        "Python is a programming language with objects, modules, threads, exceptions and automatic memory management. The benefits of pythons are that it is simple and easy, portable, extensible, build-in data structure and it is an open source.\n\n2) What is pickling and unpickling?\n\n" +
                        "\n" +
                        "Pickle module accepts any Python object and converts it into a string representation and dumps it into a file by using dump function, this process is called pickling. While the process of retrieving original Python objects from the stored string representation is called unpickling.\n" +
                        "\n\n" +
                        "3) How Python is interpreted?\n\n" +
                        "\n" +
                        "Python language is an interpreted language. Python program runs directly from the source code. It converts the source code that is written by the programmer into an intermediate language, which is again translated into machine language that has to be executed.\n" +
                        "\n\n" +
                        "4) How memory is managed in Python?\n\n" +
                        "\n" +
                        "Python memory is managed by Python private heap space. All Python objects and data structures are located in a private heap. The programmer does not have an access to this private heap and interpreter takes care of this Python private heap.\n" +
                        "The allocation of Python heap space for Python objects is done by Python memory manager. The core API gives access to some tools for the programmer to code.\n" +
                        "Python also have an inbuilt garbage collector, which recycle all the unused memory and frees the memory and makes it available to the heap space.\n\n" +
                        "5) What are the tools that help to find bugs or perform static analysis?\n\n" +
                        "\n" +
                        "PyChecker is a static analysis tool that detects the bugs in Python source code and warns about the style and complexity of the bug. Pylint is another tool that verifies whether the module meets the coding standard.\n" +
                        "\n" +
                        "6) What are Python decorators?\n" +
                        "\n" +
                        "A Python decorator is a specific change that we make in Python syntax to alter functions easily.\n" +
                        "\n" +
                        "7) What is the difference between list and tuple?\n\n" +
                        "\n" +
                        "The difference between list and tuple is that list is mutable while tuple is not. Tuple can be hashed for e.g as a key for dictionaries.\n" +
                        "\n" +
                        "8) How are arguments passed by value or by reference?\n\n" +
                        "\n" +
                        "Everything in Python is an object and all variables hold references to the objects. The references values are according to the functions; as a result you cannot change the value of the references. However, you can change the objects if it is mutable.\n" +
                        "\n" +
                        "9) What is Dict and List comprehensions are?\n\n" +
                        "\n" +
                        "They are syntax constructions to ease the creation of a Dictionary or List based on existing iterable.\n" +
                        "\n" +
                        "10) What are the built-in type does python provides?\n\n" +
                        "\n" +
                        "There are mutable and Immutable types of Pythons built in types Mutable built-in types\n" +
                        "\n" +
                        "List\n" +
                        "Sets\n" +
                        "Dictionaries\n" +
                        "Immutable built-in types\n" +
                        "\n" +
                        "Strings\n" +
                        "Tuples\n" +
                        "Numbers\n" +
                        "11) What is namespace in Python?\n\n" +
                        "\n" +
                        "In Python, every name introduced has a place where it lives and can be hooked for. This is known as namespace. It is like a box where a variable name is mapped to the object placed. Whenever the variable is searched out, this box will be searched, to get corresponding object.\n" +
                        "\n" +
                        "12) What is lambda in Python?\n\n" +
                        "\n" +
                        "It is a single expression anonymous function often used as inline function.\n" +
                        "\n" +
                        "13) Why lambda forms in python does not have statements?\n\n" +
                        "\n" +
                        "A lambda form in python does not have statements as it is used to make new function object and then return them at runtime.\n" +
                        "\n" +
                        "14) What is pass in Python?\n\n" +
                        "\n" +
                        "Pass means, no-operation Python statement, or in other words it is a place holder in compound statement, where there should be a blank left and nothing has to be written there.")

                topicList[j_textss[0]]=topic1
                topicList[j_textss[1]]=topic2
                topicList[j_textss[2]]=topic3
                topicList[j_textss[3]]=topic4
                topicList[j_textss[4]]=topic5
                topicList[j_textss[5]]=topic6
                topicList[j_textss[6]]=topic7
                topicList[j_textss[7]]=topic8
                topicList[j_textss[8]]=topic9
                topicList[j_textss[9]]=topic10
                topicList[j_textss[10]]=topic11



                listViewAdapter = ExpendableViewAdapter(this, j_textss, topicList)
                val recycle = findViewById<ExpandableListView>(R.id.asListView)

                recycle.setAdapter(listViewAdapter)

            }
            intent.getStringExtra("data")==".Net programming" -> {

                supportActionBar!!.setTitle(".Net Programs")
                (j_textss as ArrayList<String>).add("1.Print fibonacci series C#")
                (j_textss as ArrayList<String>).add("2.C# program to check prime number")
                (j_textss as ArrayList<String>).add("3.C# program to check palindrome number.")
                (j_textss as ArrayList<String>).add("4.C# program to print factorial of a number")
                (j_textss as ArrayList<String>).add("5.C# program to check armstrong number")
                (j_textss as ArrayList<String>).add("6.C# program to print sum of digits")
                (j_textss as ArrayList<String>).add("7.C# program to reverse given number.")
                (j_textss as ArrayList<String>).add("8.C# program to swap two numbers without using third variable.")
                (j_textss as ArrayList<String>).add("9.C# program to convert decimal number to binary.")
                (j_textss as ArrayList<String>).add("10.C# Program to Convert Number in Characters")
                (j_textss as ArrayList<String>).add("Interview Questions C#")
                display.addAll(j_textss)
                val topic1:MutableList<String> = ArrayList()
                topic1.add("using System;  \n" +
                        "  public class FibonacciExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "         int n1=0,n2=1,n3,i,number;    \n" +
                        "         Console.Write(\"Enter the number of elements: );    \n" +
                        "         number = int.Parse(Console.ReadLine());  \n" +
                        "         Console.Write(n1+\" \"+n2+\" \"); //printing 0 and 1    \n" +
                        "         for(i=2;i<number;++i) //loop starts from 2 because 0 and 1 are already printed    " +
                        "         {    \n" +
                        "          n3=n1+n2;    \n" +
                        "          Console.Write(n3+\" \");    \n" +
                        "          n1=n2;    \n" +
                        "          n2=n3;    " +
                        "         }    " +
                        "      }  " +
                        "   }  \n" +
                        "\n" +
                        "output:\n" +
                        "Enter the number of elements: 15 " +
                        "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 ")

                val topic2:MutableList<String> = ArrayList()
                topic2.add("using System;  \n" +
                        "  public class PrimeNumberExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "          int n, i, m=0, flag=0;    \n" +
                        "          Console.Write(\"Enter the Number to check Prime: \");    \n" +
                        "          n = int.Parse(Console.ReadLine());  \n" +
                        "          m=n/2;    \n" +
                        "          for(i = 2; i <= m; i++)    " +
                        "          {    \n" +
                        "           if(n % i == 0)    " +
                        "            {    \n" +
                        "             Console.Write(\"Number is not Prime.\");    \n" +
                        "             flag=1;    \n" +
                        "             break;    " +
                        "            }    " +
                        "          }    \n" +
                        "          if (flag==0)    \n" +
                        "           Console.Write(\"Number is Prime.\");       " +
                        "     }  " +
                        "   }  \n" +
                        "output:\n" +
                        "Enter the Number to check Prime: 17  \n" +
                        "Number is Prime.   ")


                val topic3:MutableList<String> = ArrayList()
                topic3.add("using System;  \n" +
                        "  public class PalindromeExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "          int n,r,sum=0,temp;    \n" +
                        "          Console.Write(\"Enter the Number: \");   \n" +
                        "          n = int.Parse(Console.ReadLine());  \n" +
                        "          temp=n;      \n" +
                        "          while(n>0)      " +
                        "          {      \n" +
                        "           r=n%10;      \n" +
                        "           sum=(sum*10)+r;      \n" +
                        "           n=n/10;      " +
                        "          }      \n" +
                        "          if(temp==sum)      \n" +
                        "           Console.Write(\"Number is Palindrome.\");      \n" +
                        "          else      \n" +
                        "           Console.Write(\"Number is not Palindrome\");     " +
                        "    }  " +
                        "  }  " +
                        "\n" +
                        "output:\n" +
                        "Enter the Number=121   \n" +
                        "Number is Palindrome.")

                val topic4:MutableList<String> = ArrayList()
                topic4.add("using System;  \n" +
                        "  public class FactorialExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "       int i,fact=1,number;      \n" +
                        "       Console.Write(\"Enter any Number: \");      \n" +
                        "       number= int.Parse(Console.ReadLine());     \n" +
                        "       for(i=1;i<=number;i++){      \n" +
                        "        fact=fact*i;      " +
                        "       }      \n" +
                        "       Console.Write(\"Factorial of \" +number+\" is: \"+fact);    " +
                        "     }  " +
                        "  }  \n" +
                        "output:\n" +
                        "Enter any Number: 6\n" +
                        "Factorial of 6 is: 720")

                val topic5:MutableList<String> = ArrayList()
                topic5.add("using System;  \n" +
                        "  public class ArmstrongExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "       int  n,r,sum=0,temp;      \n" +
                        "       Console.Write(\"Enter the Number= \");      \n" +
                        "       n= int.Parse(Console.ReadLine());     \n" +
                        "       temp=n;      \n" +
                        "       while(n>0)      " +
                        "       {      \n" +
                        "        r=n%10;      \n" +
                        "        sum=sum+(r*r*r);      \n" +
                        "        n=n/10;      " +
                        "       }      \n" +
                        "       if(temp==sum)      \n" +
                        "        Console.Write(\"Armstrong Number.\");      \n" +
                        "       else      \n" +
                        "        Console.Write(\"Not Armstrong Number.\");      " +
                        "      }  " +
                        "  }  \n" +
                        "\n" +
                        "output:\n" +
                        "Enter the Number= 371\n" +
                        "Armstrong Number.\n" +
                        "\n" +
                        "Enter the Number= 342   \n" +
                        "Not Armstrong Number. ")

                val topic6:MutableList<String> = ArrayList()
                topic6.add("using System;  \n" +
                        "  public class SumExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "       int  n,sum=0,m;         \n" +
                        "       Console.Write(\"Enter a number: \");      \n" +
                        "       n= int.Parse(Console.ReadLine());     \n" +
                        "       while(n>0)      " +
                        "       {      \n" +
                        "        m=n%10;      \n" +
                        "        sum=sum+m;      \n" +
                        "        n=n/10;      " +
                        "       }      \n" +
                        "       Console.Write(\"Sum is= \"+sum);       " +
                        "     }  " +
                        "  }  \n" +
                        "output:\n" +
                        "Enter a number: 23  \n" +
                        "Sum is= 5\n" +
                        "Enter a number: 624       \n" +
                        "Sum is= 12")

                val topic7:MutableList<String> = ArrayList()
                topic7.add("using System;  \n" +
                        "  public class ReverseExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "       int  n, reverse=0, rem;           \n" +
                        "       Console.Write(\"Enter a number: \");      \n" +
                        "       n= int.Parse(Console.ReadLine());     \n" +
                        "       while(n!=0)      " +
                        "       {      \n" +
                        "        rem=n%10;        \n" +
                        "        reverse=reverse*10+rem;      \n" +
                        "        n/=10;      " +
                        "       }      \n" +
                        "       Console.Write(\"Reversed Number: \"+reverse);       " +
                        "    }  " +
                        "  }  \n" +
                        "output:\n" +
                        "Enter a number: 234  \n" +
                        "Reversed Number: 432")

                val topic8:MutableList<String> = ArrayList()
                topic8.add("using System;  \n" +
                        "  public class SwapExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "       int  a=5, b=10;            \n" +
                        "       Console.WriteLine(\"Before swap a= \"+a+\" b= \"+b);    \n" +
                        "       a=a*b; //a=50 (5*10)      \n" +
                        "       b=a/b; //b=5 (50/10)      \n" +
                        "       a=a/b; //a=10 (50/5)    \n" +
                        "       Console.Write(\"After swap a= \"+a+\" b= \"+b);       " +
                        "     }  " +
                        "  }   " +
                        "\n" +
                        "output:\n" +
                        "Before swap a= 5 b= 10     \n" +
                        "After swap a= 10 b= 5")

                val topic9:MutableList<String> = ArrayList()
                topic9.add("using System;  \n" +
                        "  public class ConversionExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "       int  n, i;       \n" +
                        "       int[] a = new int[10];     \n" +
                        "       Console.Write(\"Enter the number to convert: \");    \n" +
                        "       n= int.Parse(Console.ReadLine());     \n" +
                        "       for(i=0; n>0; i++)      " +
                        "        {      \n" +
                        "         a[i]=n%2;      \n" +
                        "         n= n/2;    " +
                        "        }      \n" +
                        "       Console.Write(\"Binary of the given number= \");      \n" +
                        "       for(i=i-1 ;i>=0 ;i--)      " +
                        "       {      \n" +
                        "        Console.Write(a[i]);      " +
                        "       }                 " +
                        "      }  " +
                        "  }  \n" +
                        "\n" +
                        "output:\n" +
                        "Enter the number to convert:10\n" +
                        "Binary of the given number= 1010 ")

                val topic10:MutableList<String> = ArrayList()
                topic10.add("using System;  \n" +
                        "  public class ConversionExample  " +
                        "   {  \n" +
                        "     public static void Main(string[] args)  " +
                        "      {  \n" +
                        "       int n,sum=0,r;     \n" +
                        "       Console.Write(\"Enter the Number= \");    \n" +
                        "       n= int.Parse(Console.ReadLine());     \n" +
                        "       while(n>0)      " +
                        "       {      \n" +
                        "        r=n%10;      \n" +
                        "        sum=sum*10+r;      \n" +
                        "        n=n/10;      " +
                        "       }      \n" +
                        "       n=sum;      \n" +
                        "       while(n>0)      " +
                        "       {      \n" +
                        "        r=n%10;      \n" +
                        "        switch(r)      " +
                        "        {      \n" +
                        "         case 1:      \n" +
                        "         Console.Write(\"one \");  \n" +
                        "         break;      \n" +
                        "         case 2:      \n" +
                        "         Console.Write(\"two \");      \n" +
                        "         break;      \n" +
                        "         case 3:      \n" +
                        "         Console.Write(\"three \");    \n" +
                        "         break;      \n" +
                        "         case 4:      \n" +
                        "         Console.Write(\"four \");    \n" +
                        "         break;      \n" +
                        "         case 5:      \n" +
                        "         Console.Write(\"five \");    \n" +
                        "         break;      \n" +
                        "         case 6:      \n" +
                        "         Console.Write(\"six \");     \n" +
                        "         break;      \n" +
                        "         case 7:    \n" +
                        "         Console.Write(\"seven \");    \n" +
                        "         break;    \n" +
                        "         case 8:      \n" +
                        "         Console.Write(\"eight \");      \n" +
                        "         break;      \n" +
                        "         case 9:      \n" +
                        "         Console.Write(\"nine \");    \n" +
                        "         break;      \n" +
                        "         case 0:      \n" +
                        "         Console.Write(\"zero \");    \n" +
                        "         break;      \n" +
                        "         default:      \n" +
                        "         Console.Write(\"tttt \");      \n" +
                        "         break;      " +
                        "        }//end of switch      \n" +
                        "        n=n/10;      " +
                        "       }//end of while loop       " +
                        "   }  " +
                        "  }  \n" +
                        "\n" +
                        "output:\n" +
                        "Enter the Number= 357546\n" +
                        "three five seven five four six\n")

                val topic11:MutableList<String> = ArrayList()
                topic11.add("1) What is C#?\n" +
                        "\n" +
                        "C# is an object-oriented, type-safe, and managed language that is compiled by .Net framework to generate Microsoft Intermediate Language." +
                        "\n" +
                        "2) Explain types of comment in C# with examples\n" +
                        "Single line\n" +
                        "\n" +
                        "Example:\n" +
                        "\n" +
                        "//This is a single line comment\n" +
                        "ii. Multiple line (/* */)\n" +
                        "\n" +
                        "Example:\n" +
                        "\n" +
                        "/*This is a multiple line comment\n" +
                        "We are in line 2\n" +
                        "Last line of comment*/\n" +
                        "iii. XML Comments (///).\n" +
                        "\n" +
                        "Eg:\n" +
                        "\n" +
                        "/// summary;\n" +
                        "/// Set error message for multilingual language.\n" +
                        "/// summary \n " +
                        "3) Can multiple catch blocks be executed?\n" +
                        "\n" +
                        "No, Multiple catch blocks of similar type can't be executed. Once the proper catch code executed, the control is transferred to the finally block, and then the code that follows the finally block gets executed.\n" +
                        "\n" +
                        "4) What is the difference between public, static, and void?\n" +
                        "\n" +
                        "Public declared variables or methods are accessible anywhere in the application. Static declared variables or methods are globally accessible without creating an instance of the class. Static member are by default not globally accessible it depends upon the type of access modified used. The compiler stores the address of the method as the entry point and uses this information to begin execution before any objects are created. And Void is a type modifier that states that the method or variable does not return any value." +
                        "\n\n5) Define Constructors\n" +
                        "\n" +
                        "A constructor is a member function in a class that has the same name as its class. The constructor is automatically invoked whenever an object class is created. It constructs the values of data members while initializing the class.\n" +
                        "\n" +
                        "6) What is Jagged Arrays?\n" +
                        "\n" +
                        "The Array which has elements of type array is called jagged Array. The elements can be of different dimensions and sizes. We can also call jagged Array as an Array of arrays.\n" +
                        "\n" +
                        "7) What is the difference between ref & out parameters?\n" +
                        "\n" +
                        "An argument passed as ref must be initialized before passing to the method whereas out parameter needs not to be initialized before passing to a method.\n" +
                        "\n" +
                        "8) What is the use of 'using' statement in C#?\n" +
                        "\n" +
                        "The 'using' block is used to obtain a resource and process it and then automatically dispose of when the execution of the block completed.\n" +
                        "\n" +
                        "9) What is serialization?\n" +
                        "\n" +
                        "When we want to transport an object through a network, then we have to convert the object into a stream of bytes. The process of converting an object into a stream of bytes is called Serialization. For an object to be serializable, it should implement ISerialize Interface. De-serialization is the reverse process of creating an object from a stream of bytes.\n" +
                        "\n" +
                        "10) Can we use \"this\" command within a static method?\n" +
                        "\n" +
                        "We can't use 'This' in a static method because we can only use static variables/methods in a static method.\n" +
                        "\n" +
                        "11) What is the difference between constants and read-only?\n" +
                        "\n" +
                        "Constant variables are declared and initialized at compile time. The value can't be changed afterward. Read-only is used only when we want to assign the value at run time." +
                        "12) What's the difference between the System.Array.CopyTo() and System.Array.Clone() ?\n" +
                        "\n" +
                        "Using Clone() method, we creates a new array object containing all the elements in the original Array and using CopyTo() method. All the elements of existing array copies into another existing array. Both methods perform a shallow copy.\n" +
                        "\n" +
                        "13). How can we sort the elements of the Array in descending order?\n" +
                        "\n" +
                        "Using Sort() methods followed by Reverse() method.\n" +
                        "\n" +
                        "14) Write down the C# syntax to catch an exception\n" +
                        "\n" +
                        "To catch an exception, we use try-catch blocks. Catch block can have a parameter of system.Exception type.\n" +
                        "\n" +
                        "Eg:\n" +
                        "\n" +
                        "try {\n" +
                        "    GetAllData();\n" +
                        "} \n" +
                        "catch (Exception ex) {\n" +
                        "}\n" +
                        "In the above example, we can omit the parameter from catch statement.\n" +
                        "\n" +
                        "15) What's the difference between an interface and abstract class?\n" +
                        "\n" +
                        "Interfaces have all the methods having only declaration but no definition. In an abstract class, we can have some concrete methods. In an interface class, all the methods are public. An abstract class may have private methods.\n" +
                        "\n" +
                        "16) What is the difference between Finalize() and Dispose() methods?\n" +
                        "\n" +
                        "Dispose() is called when we want for an object to release any unmanaged resources with them. On the other hand, Finalize() is used for the same purpose, but it doesn't assure the garbage collection of an object.\n" +
                        "\n" +
                        "17) What are circular references?\n" +
                        "\n" +
                        "Circular reference is situation in which two or more resources are interdependent on each other causes the lock condition and make the resources unusable.\n" +
                        "\n" +
                        "18) What are generics in C#.NET?\n" +
                        "\n" +
                        "Generics are used to make reusable code classes to decrease the code redundancy, increase type safety, and performance. Using generics, we can create collection classes. To create generic collection, System.Collections.Generic namespace should be used instead of classes such as ArrayList in the System.Collections namespace. Generics promotes the usage of parameterized types.\n" +
                        "\n" +
                        "19) What is an object pool in .NET?\n" +
                        "\n" +
                        "An object pool is a container having objects ready to be used. It tracks the object that is currently in use, total number of objects in the pool. This reduces the overhead of creating and re-creating objects.\n" +
                        "\n" +
                        "20) List down the commonly used types of exceptions in .net\n" +
                        "\n" +
                        "ArgumentException, ArgumentNullException , ArgumentOutOfRangeException, ArithmeticException, DivideByZeroException ,OverflowException , IndexOutOfRangeException ,InvalidCastException ,InvalidOperationException , IOEndOfStreamException , NullReferenceException , OutOfMemoryException , StackOverflowException etc.\n" +
                        "\n" +
                        "21) What are Custom Exceptions?\n" +
                        "\n" +
                        "Sometimes there are some errors that need to be handled as per user requirements. Custom exceptions are used for them and are used defined exceptions.\n" +
                        "\n" +
                        "22) What are delegates?\n" +
                        "\n" +
                        "Delegates are same are function pointers in C++, but the only difference is that they are type safe, unlike function pointers. Delegates are required because they can be used to write much more generic type-safe functions.\n" +
                        "\n" +
                        "23) How do you inherit a class into other class in C#?\n" +
                        "\n" +
                        "Colon is used as inheritance operator in C#. Just place a colon and then the class name.\n" +
                        "\n" +
                        "public class DerivedClass : BaseClass\n" +
                        "\n" +
                        "24) What is the base class in .net from which all the classes are derived from?\n" +
                        "\n" +
                        "System.Object\n" +
                        "25) What is the difference between method overriding and method overloading?\n" +
                        "\n" +
                        "In method overriding, we change the method definition in the derived class that changes the method behavior. Method overloading is creating a method with the same name within the same class having different signatures.\n" +
                        "\n" +
                        "26) What are the different ways a method can be overloaded?\n" +
                        "\n" +
                        "Methods can be overloaded using different data types for a parameter, different order of parameters, and different number of parameters.\n" +
                        "\n" +
                        "27) Why can't you specify the accessibility modifier for methods inside the interface?\n" +
                        "\n" +
                        "In an interface, we have virtual methods that do not have method definition. All the methods are there to be overridden in the derived class. That's why they all are public.\n" +
                        "\n" +
                        "28) How can we set the class to be inherited, but prevent the method from being over-ridden?\n" +
                        "\n" +
                        "Declare the class as public and make the method sealed to prevent it from being overridden.\n" +
                        "\n" +
                        "29 What happens if the inherited interfaces have conflicting method names?\n" +
                        "\n" +
                        "Implement is up to you as the method is inside your own class. There might be a problem when the methods from different interfaces expect different data, but as far as compiler cares you're okay.\n" +
                        "\n" +
                        "30. What is the difference between a Struct and a Class?\n" +
                        "\n" +
                        "Structs are value-type variables, and classes are reference types. Structs stored on the Stack causes additional overhead but faster retrieval. Structs cannot be inherited.\n" +
                "")

                topicList[j_textss[0]]=topic1
                topicList[j_textss[1]]=topic2
                topicList[j_textss[2]]=topic3
                topicList[j_textss[3]]=topic4
                topicList[j_textss[4]]=topic5
                topicList[j_textss[5]]=topic6
                topicList[j_textss[6]]=topic7
                topicList[j_textss[7]]=topic8
                topicList[j_textss[8]]=topic9
                topicList[j_textss[9]]=topic10
                topicList[j_textss[10]]=topic11



                listViewAdapter = ExpendableViewAdapter(this, j_textss, topicList)
                val recycle = findViewById<ExpandableListView>(R.id.asListView)

                recycle.setAdapter(listViewAdapter)


            }
            intent.getStringExtra("data")=="Mouse Programming" -> {

                supportActionBar!!.setTitle("Mouse Program")

                (j_textss as ArrayList<String>).add("1.C program to show how to enable Graphics mode ")
                (j_textss as ArrayList<String>).add("2.C program to check mouse status")
                (j_textss as ArrayList<String>).add("3.C++ program to implement onClick functionality in OpenGL to draw a circle ")
                (j_textss as ArrayList<String>).add("4.C++ program to show how to enable Graphics mode ")
                (j_textss as ArrayList<String>).add("5.C toggle microcontroller port0 ")
                (j_textss as ArrayList<String>).add("6.Toggle p1.5  ")
                (j_textss as ArrayList<String>).add("7.C program to check mouse status ")
                (j_textss as ArrayList<String>).add("8.Display Mouse Pointer in graphics mode")
                (j_textss as ArrayList<String>).add("9.C program to determine the current mouse position and button clicked")
                (j_textss as ArrayList<String>).add("10.Program To Restrict The Mouse Pointer Within A Boundary")
               // (j_textss as ArrayList<String>).add("Interview Questions Mouse")
                display.addAll(j_textss)
                val topic1:MutableList<String> = ArrayList()
                topic1.add("#include <conio.h>\n" +
                        "#include <graphics.h>\n" +
                        "  \n" +
                        "// Driver Code\n" +
                        "int main()" +
                        "{\n" +
                        "    int gdriver = DETECT, gmode, errorcode;\n" +
                        "    initgraph(&gdriver, &gmode, \"C:\\\\TC\\\\BGI\");\n" +
                        "  \n" +
                        "    errorcode = graphresult();\n" +
                        "  \n" +
                        "    // If error occurs\n" +
                        "    if (errorcode == grOk)\n" +
                        "        printf(\"Graphics enabled: %s\\n\",\n" +
                        "               grapherrormsg(errorcode));\n" +
                        "    else\n" +
                        "        printf(\"Graphics error: %s\\n\",\n" +
                        "               grapherrormsg(errorcode));\n" +
                        "  \n" +
                        "    getch();\n" +
                        "  \n" +
                        "    // Close the graph init()\n" +
                        "    closegraph();\n" +
                        "    return 0;\n" +
                        "}")

                val topic2:MutableList<String> = ArrayList()
                topic2.add("#include <conio.h>\n" +
                        "#include <dos.h>\n" +
                        "#include <graphics.h>\n" +
                        "#include <stdio.h>\n" +
                        "union REGS in, out;\n" +
                        "  \n" +
                        "// Function to implement the functionality\n" +
                        "// of detecting Mouse\n" +
                        "void detectMouse()" +
                        "{\n" +
                        "    in.x.ax = 0;\n" +
                        "  \n" +
                        "    // Invoke interrupt (in86 method\n" +
                        "    // description mentionde above)\n" +
                        "    int86(0X33, &in, &out);\n" +
                        "  \n" +
                        "    if (out.x.ax == 0)\n" +
                        "        printf(\"\\nMouse Failed To Initialize\");\n" +
                        "    else\n" +
                        "        printf(\"\\nMouse was Succesfully Initialized\");" +
                        "}\n" +
                        "  \n" +
                        "// Driver Code\n" +
                        "int main()" +
                        "{\n" +
                        "    clrscr();\n" +
                        "  \n" +
                        "    int gdriver = DETECT, gmode;\n" +
                        "  \n" +
                        "    // Method to enable graphics\n" +
                        "    initgraph(&gdriver, &gmode, \"c:\\tc\\bgi\");\n" +
                        "  \n" +
                        "    // Function Call\n" +
                        "    detectMouse();\n" +
                        "    getch();\n" +
                        "  \n" +
                        "    // Close graphics mode\n" +
                        "    closegraph();\n" +
                        "  \n" +
                        "    return 0;" +
                        "}")


                val topic3:MutableList<String> = ArrayList()
                topic3.add("#include <GL/glut.h>\n" +
                        "#include <iostream>\n" +
                        "#include <math.h>\n" +
                        "#include <stdlib.h>\n" +
                        "#define xpix 500\n" +
                        "#include <cstring>\n" +
                        "using namespace std;\n" +
                        "  \n" +
                        "float r, g, b, x, y;\n" +
                        "bool flag = true;\n" +
                        "int counter = 0;\n" +
                        "  \n" +
                        "// Function works on mouse click\n" +
                        "void mouse(int button, int state,\n" +
                        "           int mousex, int mousey)" +
                        "{\n" +
                        "    if (button == GLUT_LEFT_BUTTON\n" +
                        "        && state == GLUT_DOWN) {\n" +
                        "        flag = true;\n" +
                        "        x = mousex;\n" +
                        "        y = 600 - mousey;" +
                        "    }\n" +
                        "  \n" +
                        "    // Change color of circle\n" +
                        "    else if (button == GLUT_RIGHT_BUTTON\n" +
                        "             && state == GLUT_DOWN) {\n" +
                        "        if (counter > 4) {\n" +
                        "            counter = 0;" +
                        "        }\n" +
                        "  \n" +
                        "        counter++;\n" +
                        "  \n" +
                        "        // Redisplay\n" +
                        "        glutPostRedisplay();" +
                        "    }" +
                        "}\n" +
                        "  \n" +
                        "// Function that exits from program\n" +
                        "void keyboard(unsigned char key,\n" +
                        "              int x, int y)" +
                        "{\n" +
                        "    switch (key) {\n" +
                        "    case 27:\n" +
                        "        glutHideWindow();" +
                        "    }" +
                        "}\n" +
                        "  \n" +
                        "// Function to draw the circle\n" +
                        "void display(void)" +
                        "{\n" +
                        "    float angle_theta;\n" +
                        "    if (counter == 1) {\n" +
                        "        glColor3f(1, 0, 0);" +
                        "    }\n" +
                        "    else if (counter == 2) {\n" +
                        "        glColor3f(0, 1, 0);" +
                        "    }\n" +
                        "    else if (counter == 3) {\n" +
                        "        glColor3f(0, 1, 1);" +
                        "    }\n" +
                        "    else if (counter == 4) {\n" +
                        "        glColor3f(0.5, 0, 1);" +
                        "    }\n" +
                        "    else if (counter == 5) {\n" +
                        "  \n" +
                        "        glColor3f(0, 0.5, 1);" +
                        "    }\n" +
                        "  \n" +
                        "    // Matrix mode\n" +
                        "    glMatrixMode(GL_PROJECTION);\n" +
                        "    glLoadIdentity();\n" +
                        "  \n" +
                        "    // Given the coordinates\n" +
                        "    gluOrtho2D(0.0, 800.0,\n" +
                        "               0.0, 600.0);\n" +
                        "  \n" +
                        "    // If the flag is true\n" +
                        "    if (flag) {\n" +
                        "  \n" +
                        "        // Begin the pointer\n" +
                        "        glBegin(GL_POLYGON);\n" +
                        "  \n" +
                        "        // Iterate through all the\n" +
                        "        // 360 degres\n" +
                        "        for (int i = 0; i < 360; i++) {\n" +
                        "  \n" +
                        "            // Find the angle\n" +
                        "            angle_theta = i * 3.142 / 180;\n" +
                        "            glVertex2f(x + 50 * cos(angle_theta),\n" +
                        "                       y + 50 * sin(angle_theta));" +
                        "        }\n" +
                        "  \n" +
                        "        // Sets vertex\n" +
                        "        glEnd();" +
                        "    }\n" +
                        "  \n" +
                        "    // Flushes the frame buffer\n" +
                        "    // to the screen\n" +
                        "    glFlush();\n" +
                        "}\n" +
                        "  \n" +
                        "// Driver Code\n" +
                        "int main(int argc, char** argv)" +
                        "{\n" +
                        "  \n" +
                        "    glutInit(&argc, argv);\n" +
                        "    glutInitWindowSize(800, 600);\n" +
                        "    glutInitWindowPosition(100, 100);\n" +
                        "    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);\n" +
                        "  \n" +
                        "    // Creates the window as\n" +
                        "    // specified by the user\n" +
                        "    glutCreateWindow(\"Circle Creation \"\n" +
                        "                     \"on mouse click\");\n" +
                        "  \n" +
                        "    // Sets the background color\n" +
                        "    glClearColor(0, 0, 0, 0);\n" +
                        "  \n" +
                        "    // Clears the frame buffer\n" +
                        "    glClear(GL_COLOR_BUFFER_BIT);\n" +
                        "  \n" +
                        "    // Links display event with the\n" +
                        "    // display event handler(display)\n" +
                        "    glutDisplayFunc(display);\n" +
                        "  \n" +
                        "    // Mouse event handler\n" +
                        "    glutMouseFunc(mouse);\n" +
                        "  \n" +
                        "    // Keyboard event handler\n" +
                        "    glutKeyboardFunc(keyboard);\n" +
                        "  \n" +
                        "    // Loops the current event\n" +
                        "    glutMainLoop();" +
                        "}\n")

                val topic4:MutableList<String> = ArrayList()
                topic4.add("#include <bits/stdc++.h>\n" +
                        "#include <conio.h>\n" +
                        "#include <graphics.h>\n" +
                        "  \n" +
                        "// Driver Code\n" +
                        "int main()" +
                        "{\n" +
                        "    int gdriver = DETECT, gmode, errorcode;\n" +
                        "    initgraph(&gdriver, &gmode, \"C:\\\\TC\\\\BGI\");\n" +
                        "  \n" +
                        "    errorcode = graphresult();\n" +
                        "  \n" +
                        "    // If error occurs\n" +
                        "    if (errorcode == grOk)\n" +
                        "        cout << \"Graphics enabled: \\n\"\n" +
                        "             << grapherrormsg(errorcode);\n" +
                        "    else\n" +
                        "        cout << \"Graphics error: \\n\"\n" +
                        "             << grapherrormsg(errorcode);\n" +
                        "  \n" +
                        "    getch();\n" +
                        "  \n" +
                        "    // Close the graph init()\n" +
                        "    closegraph();\n" +
                        "    return 0;" +
                        "}")

                val topic5:MutableList<String> = ArrayList()
                topic5.add(" #include<reg51.h>\n" +
                        "\n" +
                        "\n" +
                        "void main()" +
                        "{\n" +
                        "\tinsigned int i:\n" +
                        "\t\n" +
                        "\tP0=0x00;\n" +
                        "\twhile(1)\n" +
                        "\t{\n" +
                        "\tP0=oxff;\n" +
                        "\tfor(i=0;i<255;i++);\n" +
                        "\tP0=0x00;\n" +
                        "\tfor(i=0;i<255;i++);" +
                        "\t}" +
                        "}")

                val topic6:MutableList<String> = ArrayList()
                topic6.add("#include<reg51.h>\n" +
                        "sbit a=p1^5;\n" +
                        "\n" +
                        "void main()" +
                        "{\n" +
                        "\n" +
                        "\tunsigned int k;\n" +
                        "\ta=0x00;\n" +
                        "\twhile(1)" +
                        "\t{\n" +
                        "\t\ta=0xff;\n" +
                        "\t\tfor(i=0;i<255;i++);\n" +
                        "\t\ta=0x00;\n" +
                        "\t\tfor(i=0;i<255;i++);" +
                        "\t\t}" +
                        "}")

                val topic7:MutableList<String> = ArrayList()
                topic7.add("#include<dos.h>\n" +
                        "#include<stdio.h>\n" +
                        "#include<conio.h>\n" +
                        "#include<graphics.h>\n" +
                        "\n" +
                        "void initmouse();\n" +
                        "\n" +
                        "union REGS in,out;\n" +
                        "void main()" +
                        "" +
                        "{\n" +
                        "\n" +
                        "\tinitmouse();\n" +
                        "\tgetch();" +
                        "\t" +
                        "" +
                        "" +
                        "}\n" +
                        "void initmouse()" +
                        "{\n" +
                        "\tin.x.ax=0;\n" +
                        "\tint86(0x33,&in,&out) ;\n" +
                        "\tif(out.x.ax==0)" +
                        "\t{\n" +
                        "\t printf(\"not\");" +
                        "" +
                        "\t}\n" +
                        "\telse" +
                        "\t{\n" +
                        "\t\tprintf(\"support \");" +
                        "\t}" +
                        "" +
                        "}")

                val topic8:MutableList<String> = ArrayList()
                topic8.add("#include <conio.h>\n" +
                        "#include <dos.h>\n" +
                        "#include <graphics.h>\n" +
                        "#include <stdio.h>\n" +
                        "union REGS in, out;\n" +
                        "  \n" +
                        "// Function to display the mouse\n" +
                        "// pointer\n" +
                        "void showMouse()" +
                        "{\n" +
                        "    // Set service AX = 1 for\n" +
                        "    // displaying mouse\n" +
                        "    in.x.ax = 1;\n" +
                        "    int86(0X33, &in, &out);" +
                        "}\n" +
                        "  \n" +
                        "// Function to initialize the mouse\n" +
                        "// pointer\n" +
                        "int initMouse()" +
                        "{\n" +
                        "    // Set service AX = 0 for\n" +
                        "    // detecting mouse\n" +
                        "    in.x.ax = 0;\n" +
                        "    int86(0x33, &in, &out);\n" +
                        "    return out.x.ax;" +
                        "}\n" +
                        "  \n" +
                        "// Driver Code\n" +
                        "void main()" +
                        "{\n" +
                        "    int status, gd = DETECT, gm;\n" +
                        "    clrscr();\n" +
                        "  \n" +
                        "    initgraph(&gd, &gm,\n" +
                        "              \"C:\\\\TURBOC3\\\\BGI\");\n" +
                        "  \n" +
                        "    // Get the status of mouse pointer\n" +
                        "    status = initMouse();\n" +
                        "  \n" +
                        "    // Check mouse is avilable or not\n" +
                        "    if (status == 0)\n" +
                        "        printf(\"Mouse support not\"\n" +
                        "               \" available.\\n\");\n" +
                        "    else {\n" +
                        "        printf(\"Display mouse\");\n" +
                        "        showMouse();" +
                        "    }\n" +
                        "  \n" +
                        "    getch();\n" +
                        "  \n" +
                        "    // Close the graphics\n" +
                        "    closegraph();" +
                        "}\n")

                val topic9:MutableList<String> = ArrayList()
                topic9.add("#include <conio.h>\n" +
                        "#include <dos.h>\n" +
                        "#include <graphics.h>\n" +
                        "#include <stdio.h>\n" +
                        "union REGS in, out;\n" +
                        "  \n" +
                        "// Function to initialize the mouse\n" +
                        "// pointer using graphics\n" +
                        "int initMouse()" +
                        "{\n" +
                        "    in.x.ax = 0;\n" +
                        "    int86(0X33, &in, &out);\n" +
                        "  \n" +
                        "    return out.x.ax;" +
                        "}\n" +
                        "  \n" +
                        "// Function to display the mouse\n" +
                        "// pointer using graphics\n" +
                        "void showMouse()" +
                        "{\n" +
                        "    in.x.ax = 1;\n" +
                        "    int86(0X33, &in, &out);" +
                        "}\n" +
                        "  \n" +
                        "// Function to get the current clicked\n" +
                        "// mouse position on the screen\n" +
                        "void getMousePosition(int* click,\n" +
                        "                      int* x, int* y)" +
                        "{\n" +
                        "    in.x.ax = 3;\n" +
                        "    int86(0X33, &in, &out);\n" +
                        "  \n" +
                        "    // Get the coordinates\n" +
                        "    *click = out.x.bx;\n" +
                        "  \n" +
                        "    // Update the x and y coordinates\n" +
                        "    *x = out.x.cx;\n" +
                        "    *y = out.x.dx;" +
                        "}\n" +
                        "  \n" +
                        "// Driver Code\n" +
                        "void main()" +
                        "{\n" +
                        "    int status, i, gd = DETECT, gm;\n" +
                        "  \n" +
                        "    // Initialize graphics\n" +
                        "    initgraph(&gd, &gm, \"C:\\\\TURBOC3\\\\BGI\");\n" +
                        "  \n" +
                        "    // Get the status of the mouse\n" +
                        "    status = initMouse();\n" +
                        "  \n" +
                        "    // Check if mouse is available or not\n" +
                        "    if (status == 0)\n" +
                        "        printf(\"Mouse support \"\n" +
                        "               \"not available.\\n\");\n" +
                        "    else {\n" +
                        "  \n" +
                        "        showMouse();\n" +
                        "  \n" +
                        "        // Get the current mouse position\n" +
                        "        getMousePosition(&click, &x, &y);\n" +
                        "  \n" +
                        "        while (!kbhit()) {\n" +
                        "  \n" +
                        "            getMousePosition(&click, &x, &y);\n" +
                        "            gotoxy(1, 1);\n" +
                        "            printf(\"X = %d, Y = %d\", x, y);\n" +
                        "  \n" +
                        "            if (click == 1)\n" +
                        "                printf(\"\\nLeft click at \"\n" +
                        "                       \"position = %d, %d\\t\",\n" +
                        "                       x, y);\n" +
                        "            if (click == 2)\n" +
                        "                printf(\"\\nRight click at \"\n" +
                        "                       \"position = %d, %d\\t\",\n" +
                        "                       x, y);" +
                        "        }" +
                        "    }" +
                        "  \n" +
                        "    getch();\n" +
                        "  \n" +
                        "    // Close the graphics\n" +
                        "    closegraph();" +
                        "}\n")

                val topic10:MutableList<String> = ArrayList()
                topic10.add("#include <graphics.h>\n" +
                        "union REGS in, out;\n" +
                        "void restrict (int x1,int y1,int x2, int y2)" +
                        "{\n" +
                        "\tin.x.ax = 7;\n" +
                        "\tin.x.cx = x1;\n" +
                        "\tin.x.dx = x2;\n" +
                        "\tint86 (0X33,&in,&out);\n" +
                        "\tin.x.ax = 8;\n" +
                        "\tin.x.cx = y1;\n" +
                        "\tin.x.dx = y2;\n" +
                        "\tint86 (0X33,&in,&out);" +
                        "}\n" +
                        "int main ()" +
                        "{\n" +
                        "\tdetect_mouse ();\n" +
                        "\tshowmouse_text ();\n" +
                        "\trestrict (100,100,500,500); // Change values here to create different mouse movement space.\n" +
                        "\tdetect ();\n" +
                        "\thide_mouse ();\n" +
                        "\tgetch ();\n" +
                        "\treturn 0;" +
                        "}")

                val topic11:MutableList<String> = ArrayList()
                topic11.add("")
                topicList[j_textss[0]]=topic1
                topicList[j_textss[1]]=topic2
                topicList[j_textss[2]]=topic3
                topicList[j_textss[3]]=topic4
                topicList[j_textss[4]]=topic5
                topicList[j_textss[5]]=topic6
                topicList[j_textss[6]]=topic7
                topicList[j_textss[7]]=topic8
                topicList[j_textss[8]]=topic9
                topicList[j_textss[9]]=topic10
                //topicList[j_textss[10]]=topic11



                listViewAdapter = ExpendableViewAdapter(this, j_textss, topicList)
                val recycle = findViewById<ExpandableListView>(R.id.asListView)

                recycle.setAdapter(listViewAdapter)

            }
            intent.getStringExtra("data")=="Embedded programming" -> {

                supportActionBar!!.setTitle("Embedded  Programs")

                (j_textss as ArrayList<String>).add("1.Blink the LED program in Embedded")
                (j_textss as ArrayList<String>).add("2.Displaying Number on 7-Segment Display")
                (j_textss as ArrayList<String>).add("3.Counter/Timer Calculations and Programming ")
                (j_textss as ArrayList<String>).add("4.Serial Communication Calculation and Programming using ")
                (j_textss as ArrayList<String>).add("5.Keypad Programming Using ")
                (j_textss as ArrayList<String>).add("6.LCD Programming using ")
                (j_textss as ArrayList<String>).add("7.Interface Arduino with LCD display and write a program to scroll the words \"BCA Department!!\" to left side using (16 x2) display. Explain the code also. ")
                (j_textss as ArrayList<String>).add("8.Temperature sensor program ")
                (j_textss as ArrayList<String>).add("9.Servo motor ")
                (j_textss as ArrayList<String>).add("10.Gas sensor Arduino ")
                (j_textss as ArrayList<String>).add("Interview Questions Embedded")
                display.addAll(j_textss)
                val topic1:MutableList<String> = ArrayList()
                topic1.add("#include<reg51.h>  \n" +
                        "void main()  " +
                        "{  \n" +
                        "unsigned int k;  \n" +
                        "unsigned char l,b;  \n" +
                        "while(1)  " +
                        "{  \n" +
                        "P0=0x01;  \n" +
                        "b=P0;  \n" +
                        "for(l-0;l<3000;l++);  \n" +
                        "for(k=0;k<8;k++)  " +
                        "{  \n" +
                        "b=b<<1;  \n" +
                        "P0=b;  " +
                        "}  " +
                        "}  " +
                        "}  \n" +
                        "output: |" +
                        "00000001 |" +
                        "00000011 |" +
                        "00000111....|\n" +
                        ".... And so on up to 11111111.")

                val topic2:MutableList<String> = ArrayList()
                topic2.add("#include<reg51.h> \n" +
                        "sbit a= P3^0;  \n" +
                        "sbit x= P3^1;  \n" +
                        "sbit y= P3^2;  \n" +
                        "sbit z= P3^3;  \n" +
                        "void main()  " +
                        "{  \n" +
                        "unsigned char m[10]={0?40,0xF9,0?24,0?30,0?19,0?12,0?02,0xF8,0xE00,0?10};  \n" +
                        "unsigned int i,j;  \n" +
                        "a=x=y=z=1;  \n" +
                        "while(1)  " +
                        "{  \n" +
                        "for(i=0;i<10;i++)  " +
                        "{  \n" +
                        "P2=m[i];  \n" +
                        "for(j=0;j<60000;j++);  " +
                        "}  " +
                        "}  " +
                        "}  ")


                val topic3:MutableList<String> = ArrayList()
                topic3.add("#include<reg51.h>  \n" +
                        "void main()  " +
                        "{  \n" +
                        "unsigned char j;  \n" +
                        "TMOD=0x20;  //set the timer mode//  \n" +
                        "for(j=0;j<2;j++)     //double the time delay//  " +
                        "{  \n" +
                        "TL1=0x19;       //set the time delay//  \n" +
                        "TH1=0x00;  \n" +
                        "TR1=1;      //timer is on//  \n" +
                        "While(TF1==0);  //check the flag bit//  \n" +
                        "TF1=0;  " +
                        "}  \n" +
                        "TR1=0;      //timer is off//  " +
                        "}  \n" +
                        "void delay()  " +
                        "{  \n" +
                        "unsigned int j;  \n" +
                        "for(j=0;j<30000;j++);  " +
                        "}  ")

                val topic4:MutableList<String> = ArrayList()
                topic4.add("#include<reg51.h>  \n" +
                        "void main()  " +
                        "{  \n" +
                        "SCON=0x50;      //starting of a serial communication//  \n" +
                        "TMOD=0x20;    //selected the timer mode//  \n" +
                        "TH1=3;       // load the baud rate//  \n" +
                        "TR1=1;      //Timer is ON//  \n" +
                        "SBUF='S';  //store the character inside a register//  \n" +
                        "while(TI==0);   //check the interrupt register//  \n" +
                        "TI=0;  \n" +
                        "TR1=0;      //OFF the timer//  \n" +
                        "while(1);  //continuous loop//  " +
                        "}  ")

                val topic5:MutableList<String> = ArrayList()
                topic5.add("#include<reg51.h>  \n" +
                        "sbit p=P3^0;  \n" +
                        "sbit q=P3^1;  \n" +
                        "sbit r=P3^2;  \n" +
                        "sbit s=P3^3;  \n" +
                        "void delay();  \n" +
                        "void main()  " +
                        "{  \n" +
                        "while(1)  " +
                        "{  \n" +
                        "p=0;  \n" +
                        "q=1;  \n" +
                        "r=1;  \n" +
                        "s=1;  \n" +
                        "delay();  \n" +
                        "p=1;  \n" +
                        "q=0;  \n" +
                        "r=1;  \n" +
                        "s=1;  \n" +
                        "void delay()  " +
                        "{  \n" +
                        "unsigned char i;  \n" +
                        "TMOD=0x20;       //set timer mode//  \n" +
                        "for(i=0;i<2;i++)     //double the time delay//  " +
                        "{  \n" +
                        "TL1=0x19;       //set time delay//  \n" +
                        "TH1=0x00;  \n" +
                        "TR1=1;       //timer on//  \n" +
                        "While(TF1==0);   //check flag bit//  \n" +
                        "TF1=0;  " +
                        "}  \n" +
                        "TR1=0;      //timer off//  " +
                        "}   ")

                val topic6:MutableList<String> = ArrayList()
                topic6.add("#include<reg51.h>  \n" +
                        "#define kam P0  \n" +
                        "void lcd_initi();  \n" +
                        "void lcd_dat(unsigned char );  \n" +
                        "void lcd_cmd(unsigned char );  \n" +
                        "void delay();  \n" +
                        "void display(unsigned char *s, unsigned char r)  \n" +
                        "sbit rs=P2^0;  \n" +
                        "sbit rw=P2^1;  \n" +
                        "sbit en=P2^2;  \n" +
                        "void main()  " +
                        "{  \n" +
                        "lcd_initi();  \n" +
                        "lcd_cmd(0x80);  \n" +
                        "delay(100);  \n" +
                        "lcd_cmd(0xc0);  \n" +
                        "display(\"javaTpoint\",10);  \n" +
                        "while(1);  " +
                        "}  \n" +
                        "void display(unsigned char *s, unsigned char r)  " +
                        "{  \n" +
                        "unsignedint w;  \n" +
                        "for(w=0;w<r;w++)  " +
                        "{  \n" +
                        "lcd_data(s[w]);  " +
                        "}  " +
                        "}  \n" +
                        "voidlcd_initi()  " +
                        "{  \n" +
                        "lcd_cmd(0?01);  \n" +
                        "delay(100);  \n" +
                        "lcd_cmd(0?38);  \n" +
                        "delay(100);  \n" +
                        "lcd_cmd(0?06);  \n" +
                        "delay(100);  \n" +
                        "lcd_cmd(0x0c);  \n" +
                        "delay(100);  " +
                        "}  \n" +
                        "voidlcd_dat(unsigned char dat)  " +
                        "{  \n" +
                        "kam = dat;  \n" +
                        "rs=1;  \n" +
                        "rw=0;  \n" +
                        "en=1;  \n" +
                        "delay(100);  \n" +
                        "en=0;  " +
                        "}  " +
                        "}  \n" +
                        "voidlcd_cmd(unsigned char cmd)  " +
                        "{  \n" +
                        "kam=cmd;  \n" +
                        "rs=0;  \n" +
                        "rw=0;  \n" +
                        "en=1;  \n" +
                        "delay(100);  \n" +
                        "en=0;  \n" +
                        "}  \n" +
                        "void delay( unsigned int n)  " +
                        "{  \n" +
                        "unsignedint a;  \n" +
                        "for(a=0;a<n;a++);  " +
                        "}  \n")

                val topic7:MutableList<String> = ArrayList()
                topic7.add("#include <LiquidCrystal.h>\n" +
                        "\n" +
                        "// initialize the library by associating any needed LCD interface pin\n" +
                        "// with the arduino pin number it is connected to\n" +
                        "const int rs = 12, en = 11, d4 = 5, d5 = 4, d6 = 3, d7 = 2;\n" +
                        "LiquidCrystal lcd(rs, en, d4, d5, d6, d7);\n" +
                        "\n" +
                        "void setup() {\n" +
                        "  // set up the LCD's number of columns and rows:\n" +
                        "  lcd.begin(16, 2);\n" +
                        "  // Print a message to the LCD.\n" +
                        "  lcd.print(\"B C A\");\n" +
                        "  delay(1000);" +
                        "}\n" +
                        "\n" +
                        "void loop() {\n" +
                        "  // scroll 13 positions (string length) to the left\n" +
                        "  // to move it offscreen left:\n" +
                        "  for (int positionCounter = 0; positionCounter < 13; positionCounter++) {\n" +
                        "    // scroll one position left:\n" +
                        "    lcd.scrollDisplayLeft();\n" +
                        "    // wait a bit:\n" +
                        "    delay(150);" +
                        "  }\n" +
                        "\n" +
                        "  // scroll 29 positions (string length + display length) to the right\n" +
                        "  // to move it offscreen right:\n" +
                        "  for (int positionCounter = 0; positionCounter < 29; positionCounter++) {\n" +
                        "    // scroll one position right:\n" +
                        "    lcd.scrollDisplayRight();\n" +
                        "    // wait a bit:\n" +
                        "    delay(150);" +
                        "  }\n" +
                        "\n" +
                        "  // scroll 16 positions (display length + string length) to the left\n" +
                        "  // to move it back to center:\n" +
                        "  for (int positionCounter = 0; positionCounter < 16; positionCounter++) {\n" +
                        "    // scroll one position left:\n" +
                        "    lcd.scrollDisplayLeft();\n" +
                        "    // wait a bit:\n" +
                        "    delay(150);" +
                        "  }\n" +
                        "\n" +
                        "  // delay at the end of the full loop:\n" +
                        "  delay(1000);" +
                        "" +
                        "}\n")

                val topic8:MutableList<String> = ArrayList()
                topic8.add("char degree = 176; //ASCI value of Degree\n" +
                        "\n" +
                        "void setup()" +
                        "" +
                        "{\n" +
                        "\n" +
                        "pinMode(A0,INPUT); //use A0 as temperature input\n" +
                        "\n" +
                        "pinMode(7,OUTPUT); //use pin 7 as output for buzzer\n" +
                        "\n" +
                        "Serial.begin(9600); //initiate serial transmission" +
                        "" +
                        "}\n" +
                        "\n" +
                        "/*\n" +
                        "\n" +
                        "The LM35 or TMP36 is an analog linear temperature sensor.\n" +
                        "\n" +
                        "This means that the output voltage is proportional\n" +
                        "\n" +
                        "to the temperature. The output voltage rises\n" +
                        "\n" +
                        "by 10mv for every 1 degree Celsius rise in temperature.\n" +
                        "\n" +
                        "The Arduino can read input from 0-5v.\n" +
                        "\n" +
                        "The Arduino stores this as a 10bit number(0-1023).\n" +
                        "\n" +
                        "Note that circuit configuration for TMP36 and LM35 both are same :)\n" +
                        "\n" +
                        "*/\n" +
                        "\n" +
                        "void loop()" +
                        "" +
                        "{\n" +
                        "\n" +
                        "int tmp = analogRead(A0);\n" +
                        "\n" +
                        "//Reading data from the sensor.This voltage is stored as a 10bit number.\n" +
                        "\n" +
                        "float voltage = (tmp * 5.0)/1024;\n" +
                        "\n" +
                        "//(5*temp)/1024 is to convert the 10 bit number to a voltage reading.\n" +
                        "\n" +
                        "float milliVolt = voltage * 1000;\n" +
                        "\n" +
                        "//This is multiplied by 1000 to convert it to millivolt.\n" +
                        "\n" +
                        "float tmpCel = (milliVolt-500)/10 ;\n" +
                        "\n" +
                        "//For TMP36 sensor. Range(−40°C to +125°C) Important Note: use (tmpCel = milliVolt / 10;) For LM35 sensor. Range(−55°C to +150°C) with accury 0.5 and better then TMP36 /* OR use this to direct convert 10 bit number to Celsius. For LM35 sensor -> tmpCel = ((tmp/1024)*500); For TMP36 sensor -> tmpCel = (((tmp/1024)*5)-0.5) *100; */ float tmpFer = (((tmpCel*9)/5)+32); //used to convert Celsius -> Fahrenheit Serial.print(\"10bit number(0-1023): \"); Serial.println(tmp); Serial.print(\"voltage: \"); Serial.print(voltage); Serial.println(\"V\"); Serial.print(\"millivolt: \"); Serial.print(milliVolt); Serial.println(\"mV\"); Serial.print(\"Celsius: \"); Serial.print(tmpCel); Serial.println(degree); Serial.print(\"Fahrenheit: \"); Serial.println(tmpFer); Serial.println(\"\"); if (tmp > 110) { // Activate digital output pin 8 - the LED will light up digitalWrite(7, HIGH); } else { // Deactivate digital output pin 8 - the LED will not light up digitalWrite(7, LOW); }\n" +
                        "\n" +
                        "delay(1000); }")

                val topic9:MutableList<String> = ArrayList()
                topic9.add("#include<Servo.h>\n" +
                        "\n" +
                        "Servo myservo;\n" +
                        "int pos=0;\n" +
                        "\n" +
                        "void setup()" +
                        "{\n" +
                        " myservo.attach(3); " +
                        "}\n" +
                        "void loop()" +
                        "{\n" +
                        "  for(pos=0;pos<=180;pos += 1)" +
                        "  {\n" +
                        "    myservo.write(pos);\n" +
                        "    delay(15);" +
                        "  }\n" +
                        "  for(pos=180;pos>=0;pos -= 1)" +
                        "  {\n" +
                        "    myservo.write(pos);\n" +
                        "    delay(15);" +
                        "  }" +
                        "}")

                val topic10:MutableList<String> = ArrayList()
                topic10.add("int pin8 = 8; \n" +
                        "int pin2 = 2;\n" +
                        "\n" +
                        "\n" +
                        "int sensor = A0; \n" +
                        "\n" +
                        "int sensorValue = 0; \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "void setup() { \n" +
                        "\n" +
                        "  pinMode(pin8, OUTPUT); \n" +
                        "  pinMode(2,OUTPUT);\n" +
                        "\n" +
                        "  Serial.begin(9600); " +
                        "" +
                        "} \n" +
                        "\n" +
                        "void loop() { " +
                        "\n" +
                        "  sensorValue = analogRead(sensor); \n" +
                        "\n" +
                        "  Serial.println(sensorValue); \n" +
                        "\n" +
                        " \n" +
                        "  if (sensorValue > 998) { \n" +
                        "\n" +
                        "    digitalWrite(pin8, HIGH); \n" +
                        "    digitalWrite(2,HIGH);\n" +
                        "" +
                        "  } \n" +
                        "\n" +
                        "  else { \n" +
                        "    digitalWrite(pin8, LOW); \n" +
                        "     digitalWrite(2,LOW);" +
                        "" +
                        "  } " +
                        "}")

                val topic11:MutableList<String> = ArrayList()
                topic11.add("1. What is an Embedded System?\n" +
                        "\n" +
                        "Simply speaking, it is an element of the operating system that is a part of the complete device, inclusive of the hardware as well as mechanical parts.\n" +
                        "\n" +
                        "2. Which are the three parts that the Embedded Systems are divided into?\n" +
                        "\n" +
                        "The embedded system is divided into hardware, software, and real-time operating system.\n" +
                        "\n" +
                        "3. What is the use of Embedded Systems?\n" +
                        "\n" +
                        "Embedded systems help replace several input buffers, hardware logic gates, output drivers, etc. using a comparatively inexpensive microprocessor. .\n" +
                        "\n" +
                        "4. What do you understand by a microcontroller?\n" +
                        "\n" +
                        "A microcontroller is basically a self-sufficient system that contains memory, peripherals, as well as a processor, that can be used as an embedded system.\n" +
                        "\n" +
                        "5. What do you mean by interrupt latency?\n" +
                        "\n" +
                        "Interrupt latency is the duration or the time taken to return from a disrupted service to the regular functioning. It can be improved through writing ISR routines. \n" +
                        "\n" +
                        "You may also like:\n" +
                        "\n" +
                        "10 Tips to stay focused in an interview\n" +
                        "10 Embedded C Interview Questions that your interviewer might ask\n" +
                        "6. Tell us something about Watchdog Timer.\n" +
                        "\n" +
                        "A watchdog timer is an electronic card or device that executes certain special operations after an interval in case something goes wrong with the electronic system.\n" +
                        "\n" +
                        "7. What is semaphore in your opinion?\n" +
                        "\n" +
                        "A semaphore is a kind of variable or abstract data type. It is usually used for two purposes, namely sharing access to various files, as well as sharing common memory space.\n" +
                        "\n" +
                        "8. What are recursive functions?\n" +
                        "\n" +
                        "Recursive functions are those functions that make calls to themselves before they render the final output or result. Recursive functions can also be made inline functions if required.\n" +
                        "\n" +
                        "9. What do you know about the memory leak?\n" +
                        "\n" +
                        "Memory leak is nothing but the accumulation of memory which is not cleared. It may stall the execution of the system in case it reaches a huge value for want of adequate space.\n" +
                        "\n" +
                        "10. What are the benefits of Embedded Systems?\n" +
                        "\n" +
                        "Embedded systems are inexpensive and are easy to manage. Not only are they smaller in size making them faster to load, but they also deliver quality performance by performing dedicated functions.\n" +
                        "\n" +
                        "Moreover, you can also study the following Embedded System Questions to make sure you are fully prepared for your interview.\n" +
                        "\n" +
                        "• Tell us about Pass By Value and Pass By Reference.\n" +
                        "• What do you use the Volatile keyword for?\n" +
                        "• Tell us about the different types of Semaphore.\n" +
                        "• What do you understand by a segmentation fault?\n" +
                        "• What do you mean by Anti Aliasing Filter?\n" +
                        "• Define Mutex.\n" +
                        "• How would you explain what an Inode is?\n" +
                        "• How does virtual memory work?\n" +
                        "• Differentiate between Mutexes and Semaphores.\n" +
                        "• Point out a few disadvantages of embedded systems. ")


                topicList[j_textss[0]]=topic1
                topicList[j_textss[1]]=topic2
                topicList[j_textss[2]]=topic3
                topicList[j_textss[3]]=topic4
                topicList[j_textss[4]]=topic5
                topicList[j_textss[5]]=topic6
                topicList[j_textss[6]]=topic7
                topicList[j_textss[7]]=topic8
                topicList[j_textss[8]]=topic9
                topicList[j_textss[9]]=topic10
                topicList[j_textss[10]]=topic11



                listViewAdapter = ExpendableViewAdapter(this, j_textss, topicList)
                val recycle = findViewById<ExpandableListView>(R.id.asListView)

                recycle.setAdapter(listViewAdapter)

            }
            intent.getStringExtra("data")=="C++ programming " -> {

                supportActionBar!!.setTitle("C++ Programs")

                (j_textss as ArrayList<String>).add("1.Fibonacci Series in C++")
                (j_textss as ArrayList<String>).add("2.Prime Number Program in C++")
                (j_textss as ArrayList<String>).add("3.Palindrome program in C++")
                (j_textss as ArrayList<String>).add("4.Factorial program in C++")
                (j_textss as ArrayList<String>).add("5.Armstrong Number in C++")
                (j_textss as ArrayList<String>).add("6.Sum of digits program in C++")
                (j_textss as ArrayList<String>).add("7.C++ Program to reverse number")
                (j_textss as ArrayList<String>).add("8.C++ Program to swap two numbers without third variable")
                (j_textss as ArrayList<String>).add("9.Matrix multiplication in C++")
                (j_textss as ArrayList<String>).add("10.C++ Program to convert Decimal to Binary")
                (j_textss as ArrayList<String>).add("Interview Questions C++")
                display.addAll(j_textss)
                val topic1:MutableList<String> = ArrayList()
                topic1.add("#include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main() {  \n" +
                        "  int n1=0,n2=1,n3,i,number;    \n" +
                        " cout<<\"Enter the number of elements: \";    \n" +
                        " cin>>number;    \n" +
                        " cout<<n1<< <<n2<< ; //printing 0 and 1    \n" +
                        " for(i=2;i<number;++i) //loop starts from 2 because 0 and 1 are already printed    " +
                        " {    \n" +
                        "  n3=n1+n2;    \n" +
                        "  cout<<n3<<;    \n" +
                        "  n1=n2;    \n" +
                        "  n2=n3;    " +
                        " }    \n" +
                        "   return 0;  " +
                        "   }  \n" +
                        "output:\n" +
                        "Enter the number of elements: 10 ->" +
                        "0 1 1 2 3 5 8 13 21 34")

                val topic2:MutableList<String> = ArrayList()
                topic2.add("#include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "  int n, i, m=0, flag=0;  \n" +
                        "  cout << \"Enter the Number to check Prime: \";  \n" +
                        "  cin >> n;  \n" +
                        "  m=n/2;  \n" +
                        "  for(i = 2; i <= m; i++)  " +
                        "  {  \n" +
                        "      if(n % i == 0)  " +
                        "      {  \n" +
                        "          cout<<\"Number is not Prime.\"<<endl;  \n" +
                        "          flag=1;  \n" +
                        "          break;  " +
                        "      }  " +
                        "  }  \n" +
                        "  if (flag==0)  \n" +
                        "      cout << \"Number is Prime.\"<<endl;  \n" +
                        "  return 0;  " +
                        "}  \n" +
                        "output:\n" +
                        "Enter the Number to check Prime: 17  \n" +
                        " Number is Prime.   \n" +
                        "Enter the Number to check Prime: 57  \n" +
                        "Number is not Prime.")


                val topic3:MutableList<String> = ArrayList()
                topic3.add("#include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "  int n,r,sum=0,temp;    \n" +
                        "  cout<<\"Enter the Number=\";    \n" +
                        "  cin>>n;    \n" +
                        " temp=n;    \n" +
                        " while(n>0)    " +
                        "{    \n" +
                        " r=n%10;    \n" +
                        " sum=(sum*10)+r;    \n" +
                        " n=n/10;    " +
                        "}    \n" +
                        "if(temp==sum)    \n" +
                        "cout<<\"Number is Palindrome.\";    \n" +
                        "else    \n" +
                        "cout<<\"Number is not Palindrome.\";   \n" +
                        "  return 0;  " +
                        "}    \n" +
                        "output:\n" +
                        "nter the Number=121   \n" +
                        " Number is Palindrome.\t\n" +
                        "Enter the number=113  \n" +
                        "Number is not Palindrome.")

                val topic4:MutableList<String> = ArrayList()
                topic4.add("#include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "   int i,fact=1,number;    \n" +
                        "  cout<<\"Enter any Number: \";    \n" +
                        " cin>>number;    \n" +
                        "  for(i=1;i<=number;i++){    \n" +
                        "      fact=fact*i;    " +
                        "  }    \n" +
                        "  cout<<\"Factorial of \" <<number<<\" is: \"<<fact<<endl;  \n" +
                        "  return 0;  " +
                        "}  \n" +
                        "output:\n" +
                        "Enter any Number: 5  \n" +
                        " Factorial of 5 is: 120  ")

                val topic5:MutableList<String> = ArrayList()
                topic5.add(" #include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "int n,r,sum=0,temp;    \n" +
                        "cout<<\"Enter the Number=  \";    \n" +
                        "cin>>n;    \n" +
                        "temp=n;    \n" +
                        "while(n>0)    " +
                        "{    \n" +
                        "r=n%10;    \n" +
                        "sum=sum+(r*r*r);    \n" +
                        "n=n/10;    " +
                        "}    \n" +
                        "if(temp==sum)    \n" +
                        "cout<<\"Armstrong Number.\"<<endl;    \n" +
                        "else    \n" +
                        "cout<<\"Not Armstrong Number.\"<<endl;   \n" +
                        "return 0;  " +
                        "}  \n" +
                        "output:\n" +
                        "Enter the Number= 371\n" +
                        "Armstrong Number.\n" +
                        "Enter the Number= 342   \n" +
                        "Not Armstrong Number.")

                val topic6:MutableList<String> = ArrayList()
                topic6.add("#include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "int n,sum=0,m;    \n" +
                        "cout<<\"Enter a number: \";    \n" +
                        "cin>>n;    \n" +
                        "while(n>0)    " +
                        "{    \n" +
                        "m=n%10;    \n" +
                        "sum=sum+m;    \n" +
                        "n=n/10;    " +
                        "}    \n" +
                        "cout<<\"Sum is= \"<<sum<<endl;    \n" +
                        "return 0;  " +
                        "}  \n" +
                        "output:\n" +
                        "Enter a number: 23  \n" +
                        "Sum is= 5\n" +
                        "Enter a number: 624       \n" +
                        "Sum is= 12")

                val topic7:MutableList<String> = ArrayList()
                topic7.add("#include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "int n, reverse=0, rem;    \n" +
                        "cout<<\"Enter a number: \";    \n" +
                        "cin>>n;    \n" +
                        "  while(n!=0)    " +
                        "  {    \n" +
                        "     rem=n%10;      \n" +
                        "     reverse=reverse*10+rem;    \n" +
                        "     n/=10;    " +
                        "  }    \n" +
                        " cout<<\"Reversed Number: \"<<reverse<<endl;     \n" +
                        "return 0;  " +
                        "}  \n" +
                        "output:\n" +
                        "Enter a number: 234  \n" +
                        " Reversed Number: 432")

                val topic8:MutableList<String> = ArrayList()
                topic8.add(" #include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "int a=5, b=10;      \n" +
                        "cout<<\"Before swap a= \"<<a<<\" b= \"<<b<<endl;      \n" +
                        "a=a*b; //a=50 (5*10)    \n" +
                        "b=a/b; //b=5 (50/10)    \n" +
                        "a=a/b; //a=10 (50/5)    \n" +
                        "cout<<\"After swap a= \"<<a<<\" b= \"<<b<<endl;      \n" +
                        "return 0;  " +
                        "}  \n" +
                        "output:\n" +
                        "Before swap a= 5 b= 10     \n" +
                        "After swap a= 10 b= 5")

                val topic9:MutableList<String> = ArrayList()
                topic9.add("#include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "int a[10][10],b[10][10],mul[10][10],r,c,i,j,k;    \n" +
                        "cout<<\"enter the number of row=\";    \n" +
                        "cin>>r;    \n" +
                        "cout<<\"enter the number of column=\";    \n" +
                        "cin>>c;    \n" +
                        "cout<<\"enter the first matrix element=\\n\";    \n" +
                        "for(i=0;i<r;i++)    " +
                        "{    \n" +
                        "for(j=0;j<c;j++)    " +
                        "{    \n" +
                        "cin>>a[i][j];  " +
                        "}    " +
                        "}    \n" +
                        "cout<<\"enter the second matrix element=\\n\";    \n" +
                        "for(i=0;i<r;i++)    " +
                        "{    \n" +
                        "for(j=0;j<c;j++)    " +
                        "{    \n" +
                        "cin>>b[i][j];    " +
                        "}    " +
                        "}    \n" +
                        "cout<<\"multiply of the matrix=\\n\";    \n" +
                        "for(i=0;i<r;i++)    " +
                        "{    \n" +
                        "for(j=0;j<c;j++)    " +
                        "{    \n" +
                        "mul[i][j]=0;    \n" +
                        "for(k=0;k<c;k++)    " +
                        "{    \n" +
                        "mul[i][j]+=a[i][k]*b[k][j];    " +
                        "}    " +
                        "}    " +
                        "}    \n" +
                        "//for printing result    \n" +
                        "for(i=0;i<r;i++)    " +
                        "{    \n" +
                        "for(j=0;j<c;j++)    " +
                        "{    \n" +
                        "cout<<mul[i][j]<<\" \";    " +
                        "}    \n" +
                        "cout<<\"\\n\";    " +
                        "}    \n" +
                        "return 0;  " +
                        "}   \n" +
                        "output:\n" +
                        "enter the number of row=3  \n" +
                        "enter the number of column=3  \n" +
                        "enter the first matrix element= " +
                        "1 2 3 |"+

                        "1 2 3 |" +

                        "1 2 3  \n " +
                        "enter the second matrix element= " +
                        "1 1 1 |" +
                        "2 1 2 |" +
                        "3 2 1   \n" +
                        " multiply of the matrix= " +
                        "14 9 8 |" +
                        "14 9 8 |" +
                        "14 9 8")

                val topic10:MutableList<String> = ArrayList()
                topic10.add("#include <iostream>  \n" +
                        "using namespace std;  \n" +
                        "int main()  " +
                        "{  \n" +
                        "int a[10], n, i;    \n" +
                        "cout<<\"Enter the number to convert: \";    \n" +
                        "cin>>n;    \n" +
                        "for(i=0; n>0; i++)    " +
                        "{    \n" +
                        "a[i]=n%2;    \n" +
                        "n= n/2;  " +
                        "}    \n" +
                        "cout<<\"Binary of the given number= \";    \n" +
                        "for(i=i-1 ;i>=0 ;i--)    " +
                        "{    \n" +
                        "cout<<a[i];    " +
                        "}    " +
                        "}  \n" +
                        "output:\n" +
                        "Enter the number to convert: 9\n" +
                        "Binary of the given number= 1001\n")

                val topic11:MutableList<String> = ArrayList()
                topic11.add("1. What are the different data types present in C++?\n" +
                        "The 4 data types in C++ are given below:\n" +
                        "\n" +
                        "Primitive Datatype(basic datatype). Example- char, short, int, float, long, double, bool, etc.\n" +
                        "Derived datatype. Example- array, pointer, etc.\n" +
                        "Enumeration. Example- enum\n" +
                        "User-defined data types. Example- structure, class, etc.\n\n" +
                        "2. What is the difference between C and C++?\n" +
                        "The main difference between C and C++ are provided in the table below:\n" +
                        "\n" +
                        "C\t & \tC++\n" +
                        "C is a procedure-oriented programming language.\tC++ is an object-oriented programming language.\n" +
                        "C does not support data hiding.\tData is hidden by encapsulation to ensure that data structures and operators are used as intended.\n" +
                        "C is a subset of C++\tC++ is a superset of C.\n" +
                        "Function and operator overloading are not supported in C\tFunction and operator overloading is supported in C++\n" +
                        "Namespace features are not present in C\tNamespace is used by C++, which avoids name collisions.\n" +
                        "Functions can not be defined inside structures.\tFunctions can be defined inside structures.\n" +
                        "calloc() and malloc() functions are used for memory allocation and free() function is used for memory deallocation.\tnew operator is used for memory allocation and deletes operator is used for memory deallocation.\n\n" +
                        "3. What are class and object in C++?\n" +
                        "A class is a user-defined data type that has data members and member functions. Data members are the data variables and member functions are the functions that are used to perform operations on these variables.\n" +
                        "\n" +
                        "An object is an instance of a class. Since a class is a user-defined data type so an object can also be called a variable of that data type." +
                        "\n\n4. What are the C++ access specifiers?\n" +
                        "In C++ there are the following access specifiers:\n" +
                        "\n" +
                        "Public: All data members and member functions are accessible outside the class.\n" +
                        "\n" +
                        "Protected: All data members and member functions are accessible inside the class and to the derived class.\n" +
                        "\n" +
                        "Private: All data members and member functions are not accessible outside the class.\n" +
                        "\n" +
                        "5. Define inline function\n" +
                        "If a function is inline, the compiler places a copy of the code of that function at each point where the function is called at compile time. One of the important advantages of using an inline function is that it eliminates the function calling overhead of a traditional function.\n" +
                        "\n" +
                        "6. What is a reference in C++?\n" +
                        "A reference is like a pointer. It is another name of an already existing variable. Once a reference name is initialized with a variable, that variable can be accessed by the variable name or reference name both.")
                topicList[j_textss[0]]=topic1
                topicList[j_textss[1]]=topic2
                topicList[j_textss[2]]=topic3
                topicList[j_textss[3]]=topic4
                topicList[j_textss[4]]=topic5
                topicList[j_textss[5]]=topic6
                topicList[j_textss[6]]=topic7
                topicList[j_textss[7]]=topic8
                topicList[j_textss[8]]=topic9
                topicList[j_textss[9]]=topic10
                topicList[j_textss[10]]=topic11



                listViewAdapter = ExpendableViewAdapter(this, j_textss, topicList)
                val recycle = findViewById<ExpandableListView>(R.id.asListView)

                recycle.setAdapter(listViewAdapter)


            }


              intent.getStringExtra("data")=="Programming Books" ->
              {

                  supportActionBar!!.setTitle("Programming Books ")
                  gridViews=findViewById(R.id.grid_views)
                  arrayLists= ArrayList()
                  arrayLists=setdatalists()
                  bookadapter = bookadapter(applicationContext,arrayLists, object :
                      OnCellItemClick {
                      override fun onCellClickListener(texts: String) {

                          Toast.makeText(applicationContext,texts,Toast.LENGTH_LONG).show()

                          if(texts=="java Language"){




                              val intent = Intent(
                                  Intent.ACTION_VIEW,
                                  Uri.parse("https://math.hws.edu/eck/cs124/downloads/javanotes6-linked.pdf")
                              )
                              startActivity(intent)

                          }

                          else if(texts=="C++ Language"){
                              val intent = Intent(
                                  Intent.ACTION_VIEW,
                                  Uri.parse("http://vijayacollege.ac.in/Content/PDF/c++.pdf")
                              )
                              startActivity(intent)
                          }
                          else if(texts=="C Language"){
                              val intent = Intent(
                                  Intent.ACTION_VIEW,
                                  Uri.parse("https://phy.ntnu.edu.tw/~cchen/ctutor.pdf")
                              )
                              startActivity(intent)
                          }
                          else if(texts=="Python Language"){
                              val intent = Intent(
                                  Intent.ACTION_VIEW,
                                  Uri.parse("https://www.iare.ac.in/sites/default/files/IARE_OOPS_Lecture%20Notes.pdf")
                              )
                              startActivity(intent)
                          }

                          else if(texts=="C# Language"){
                              val intent = Intent(
                                  Intent.ACTION_VIEW,
                                  Uri.parse("http://index-of.co.uk/Programming/C%23%20Book.pdf")
                              )
                              startActivity(intent)
                          }
                          else if(texts=="Embedded program Language"){
                              val intent = Intent(
                                  Intent.ACTION_VIEW,
                                  Uri.parse("https://ptolemy.berkeley.edu/books/leeseshia/releases/LeeSeshia_DigitalV2_2.pdf")
                              )
                              startActivity(intent)
                          }





                      }
                  })


                  gridViews?.adapter= bookadapter


              }

                //--------------------------
                intent.getStringExtra("data")=="MCQ" ->
                {

                    supportActionBar!!.setTitle("MCQ ")
                    gridView=findViewById(R.id.grid_mcq)
                    arrayList= ArrayList()
                    arrayList=setdatalistmcq()
                    languageAdapter = languageAdapter(applicationContext,arrayList!!, object :
                        OnCellItemClick {
                        override fun onCellClickListener(texts: String) {

                            Toast.makeText(applicationContext,texts,Toast.LENGTH_LONG).show()

                            if(texts=="java Language"){

                                supportActionBar!!.setTitle("JAVA")
                                starttime()
                                setContentView(R.layout.activity_questions)

                                setdata.getquestion()

                                questionList=setdata.getquestion()
                                setQuestion()
                                option1.setOnClickListener {
                                    selectoptionstyle(option1,1)

                                }
                                option2.setOnClickListener {
                                    selectoptionstyle(option2,2)

                                }
                                option3.setOnClickListener {
                                    selectoptionstyle(option3,3)

                                }
                                option4.setOnClickListener {
                                    selectoptionstyle(option4,4)

                                }

                                nextbtn.setOnClickListener {

                                    if(selectoption!=0)
                                    {
                                        val question=questionList!![currenposition-1]
                                        if(selectoption!=question.correct_ans)
                                        {
                                            setcolor(selectoption,R.drawable.error)

                                        }
                                        else
                                        {
                                            score++;

                                        }
                                        setcolor(question.correct_ans,R.drawable.correct)
                                        if(currenposition==questionList!!.size)
                                            nextbtn.text="FINISH"
                                        else
                                            nextbtn.text="Go to Next"
                                    }
                                    else
                                    {
                                        currenposition++
                                        when{

                                            currenposition<=questionList!!.size->{
                                                setQuestion()
                                            }
                                            else->
                                            {
                                                var intent = Intent(applicationContext,result::class.java)
                                                intent.putExtra(setdata.score,score.toString())
                                                intent.putExtra("total size",questionList!!.size.toString())
                                                startActivity(intent)
                                                finish()
                                            }
                                        }
                                    }
                                    selectoption=0
                                }


                            }

                            else if(texts=="C++ Language"){
                                setContentView(R.layout.activity_questions)
                                starttime()
                                supportActionBar!!.setTitle("C++")
                                setdata.getquestionview()

                                questionList=setdata.getquestionview()
                                setQuestion()
                                option1.setOnClickListener {
                                    selectoptionstyle(option1,1)

                                }
                                option2.setOnClickListener {
                                    selectoptionstyle(option2,2)

                                }
                                option3.setOnClickListener {
                                    selectoptionstyle(option3,3)

                                }
                                option4.setOnClickListener {
                                    selectoptionstyle(option4,4)

                                }

                                nextbtn.setOnClickListener {

                                    if(selectoption!=0)
                                    {
                                        val question=questionList!![currenposition-1]
                                        if(selectoption!=question.correct_ans)
                                        {
                                            setcolor(selectoption,R.drawable.error)

                                        }
                                        else
                                        {
                                            score++;

                                        }
                                        setcolor(question.correct_ans,R.drawable.correct)
                                        if(currenposition==questionList!!.size)
                                            nextbtn.text="FINISH"
                                        else
                                            nextbtn.text="Go to Next"
                                    }
                                    else
                                    {
                                        currenposition++
                                        when{

                                            currenposition<=questionList!!.size->{
                                                setQuestion()
                                            }
                                            else->
                                            {
                                                var intent = Intent(applicationContext,result::class.java)
                                                intent.putExtra(setdata.score,score.toString())
                                                intent.putExtra("total size",questionList!!.size.toString())
                                                startActivity(intent)
                                                finish()
                                            }

                                        }
                                    }
                                    selectoption=0
                                }

                            }
                            else if(texts=="C Language"){
                                setContentView(R.layout.activity_questions)
                                starttime()
                                supportActionBar!!.setTitle("C ")
                                setdata.getquestion_c()

                                questionList=setdata.getquestion_c()
                                setQuestion()
                                option1.setOnClickListener {
                                    selectoptionstyle(option1,1)

                                }
                                option2.setOnClickListener {
                                    selectoptionstyle(option2,2)

                                }
                                option3.setOnClickListener {
                                    selectoptionstyle(option3,3)

                                }
                                option4.setOnClickListener {
                                    selectoptionstyle(option4,4)

                                }

                                nextbtn.setOnClickListener {

                                    if(selectoption!=0)
                                    {
                                        val question=questionList!![currenposition-1]
                                        if(selectoption!=question.correct_ans)
                                        {
                                            setcolor(selectoption,R.drawable.error)

                                        }
                                        else
                                        {
                                            score++
                                        }
                                        setcolor(question.correct_ans,R.drawable.correct)
                                        if(currenposition==questionList!!.size)
                                            nextbtn.text="FINISH"
                                        else
                                            nextbtn.text="Go to Next"
                                    }
                                    else
                                    {
                                        currenposition++
                                        when{

                                            currenposition<=questionList!!.size->{
                                                setQuestion()
                                            }
                                            else->
                                            {
                                                var intent = Intent(applicationContext,result::class.java)
                                                intent.putExtra(setdata.score,score.toString())
                                                intent.putExtra("total size",questionList!!.size.toString())
                                                startActivity(intent)
                                                finish()
                                            }
                                        }
                                    }
                                    selectoption=0
                                }

                            }
                            else if(texts=="Python Language"){
                                setContentView(R.layout.activity_questions)
                                starttime()
                                supportActionBar!!.setTitle("Python ")
                                setdata.getquestion_python()

                                questionList=setdata.getquestion_python()
                                setQuestion()
                                option1.setOnClickListener {
                                    selectoptionstyle(option1,1)

                                }
                                option2.setOnClickListener {
                                    selectoptionstyle(option2,2)

                                }
                                option3.setOnClickListener {
                                    selectoptionstyle(option3,3)

                                }
                                option4.setOnClickListener {
                                    selectoptionstyle(option4,4)

                                }

                                nextbtn.setOnClickListener {

                                    if(selectoption!=0)
                                    {
                                        val question=questionList!![currenposition-1]
                                        if(selectoption!=question.correct_ans)
                                        {
                                            setcolor(selectoption,R.drawable.error)

                                        }
                                        else
                                        {
                                            score++
                                        }
                                        setcolor(question.correct_ans,R.drawable.correct)
                                        if(currenposition==questionList!!.size)
                                            nextbtn.text="FINISH"
                                        else
                                            nextbtn.text="Go to Next"
                                    }
                                    else
                                    {
                                        currenposition++
                                        when{

                                            currenposition<=questionList!!.size->{
                                                setQuestion()
                                            }
                                            else->
                                            {
                                                var intent = Intent(applicationContext,result::class.java)
                                                intent.putExtra(setdata.score,score.toString())
                                                intent.putExtra("total size",questionList!!.size.toString())
                                                startActivity(intent)
                                                finish()
                                            }
                                        }
                                    }
                                    selectoption=0
                                }

                            }

                            else if(texts=="C# Language"){
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("http://index-of.co.uk/Programming/C%23%20Book.pdf")
                                )
                                startActivity(intent)
                            }
                            else if(texts=="Embedded program Language"){
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://ptolemy.berkeley.edu/books/leeseshia/releases/LeeSeshia_DigitalV2_2.pdf")
                                )
                                startActivity(intent)
                            }





                        }
                    })


                    gridView?.adapter= languageAdapter


                }



              intent.getStringExtra("data")=="YouTube Tutorials" ->
              {


                  supportActionBar!!.setTitle("Youtube ")

                  gridView=findViewById(R.id.grid_view)
                  arrayList= ArrayList()
                  arrayList=setdatalist()
                  languageAdapter = languageAdapter(applicationContext,arrayList!!,this)

                  gridView?.adapter=languageAdapter


              }



              else -> {



              }

        }

    }

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.searchmanu,menu)

        val searchItem = menu!!.findItem(R.id.menu_search)




        return true
    }
*/









    override fun onCellClickListener(text: String) {
        //on click youtube programatically
        try{
            if(text=="java Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PLX9Zi6XTqOKQ7TdRz0QynGIKuMV9Q2H8E"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }else if(text=="C Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/EMEvheCVhMk"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }

            else if(text=="C++ Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PLLYz8uHU480j37APNXBdPz7YzAi4XlQUF"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }

            else if(text=="Python Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/playlist?list=PLbGui_ZYuhigZkqrHbI_ZkPBrIr5Rsd5L"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }
            else if(text=="C# Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SXmVym6L8dw&list=PLAC325451207E3105"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }
            else if(text=="Mouse Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0XgaHsDO_x0"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }

            else if(text=="Embedded program Language"){
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=3V9eqvkMzHA&list=PLPW8O6W-1chwyTzI3BHwBLbGQoPFxPAPM"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.google.android.youtube");
                startActivity(intent)
            }


        }catch (e:Exception){



        }

    }


        //override fun onCellClickListener(text:String) {
        //val intent = Intent(this, MainActivity2::class.java)
       // intent.putExtra("data",text)
    //startActivity(intent)
        //    }


}