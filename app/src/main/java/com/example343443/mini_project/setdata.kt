package com.example343443.mini_project

import java.util.ArrayList

object setdata {

    const val score:String=""
    fun getquestion():ArrayList<Questiondata>{
        var que:ArrayList<Questiondata> = arrayListOf()
        var q1=Questiondata(
            1,
            "1.Number of primitive data types in Java are?",
            "7",
            "6",
            "8",
            "3",
            3

        )
        var q2=Questiondata(
            2,
            "2.Automatic type conversion is possible in which of the possible cases?",
            "Byte to int",
            "Int to long",
            "Long to int",
            "Short to int",
            2

        )
        var q3=Questiondata(
            3,
            "3.Find the output of the following code.\n" +
                    "\n" +
                    "int Integer = 24;\n" +
                    "char String  = ‘I’;\n" +
                    "System.out.print(Integer);\n" +
                    "System.out.print(String);",
            "Complie error",
            "Throws exception",
            "I",
            "24 I",
            4

        )
        var q4=Questiondata(
            4,
            "4.Identify the interface which is used to declare core methods in java?",
            "Comparator",
            "EventListener",
            "Set",
            "Collection",
            4

        )
        var q5=Questiondata(
            5,
            "5.Find the output of the following program.\n" +
                    "\n" +
                    "public class Solution{\n" +
                    "       public static void main(String[] args){\n" +
                    "                     short x = 10;\n" +
                    "                     x =  x * 5;\n" +
                    "                     System.out.print(x);\n" +
                    "       }\n" +
                    "}",
            "50",
            "10",
            "Compile error",
            "Exception",
            3

        )
        var q6=Questiondata(
                6,
                "6.Find the output of the following program.\n" +
                        "\n" +
                        "public class Solution{\n" +
                        "       public static void main(String[] args){\n" +
                        "                     byte x = 127;\n" +
                        "                     x++;\n" +
                        "                     x++;\n" +
                        "                     System.out.print(x);\n" +
                        "       }\n" +
                        "}",
                "-127",
                "127",
                "21",
                "129",
                1

        )
        var q7=Questiondata(
                7,
                "7.Select the valid statement.",
                "char[] ch = new char(5)",
                "char[] ch = new char[5]",
                "char[] ch = new char()",
                "char[] ch = new char[]",
                2

        )
        var q8=Questiondata(
                8,
                "8.Find the output of the following program.\n" +
                        "\n" +
                        "public class Solution{\n" +
                        "       public static void main(String[] args){\n" +
                        "               int[]  x = {120, 200, 016};\n" +
                        "               for(int i = 0; i < x.length; i++){\n" +
                        "                        System.out.print(x[i] + “ “);\n" +
                        "               }                   \n" +
                        "       }\n" +
                        "}",
                "120 200 016",
                "120 200 16",
                "120 200 14",
                "None",
                3

        )
        var q9=Questiondata(
                9,
                "9.Select the valid statement to declare and initialize an array",
                "int[] A = {}",
                "int[] A = {1,2,3}",
                "int[] A = (1,2,3)",
                "int[][] A = {1,2,3}",
                2

        )
        var q10=Questiondata(
                10,
                " \n" +
                        "10.Find the value of A[1] after execution of the following program.\n" +
                        "\n" +
                        "int[] A = {0,2,4,1,3};\n" +
                        "for(int i = 0; i < a.length; i++){\n" +
                        "    a[i] = a[(a[i] + 3) % a.length];\n" +
                        "}",
                "0",
                "1",
                "2",
                "3",
                2

        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        que.add(q6)
        que.add(q7)
        que.add(q8)
        que.add(q9)
        que.add(q10)

        return que

    }


    fun getquestionview():ArrayList<Questiondata>{
        var que:ArrayList<Questiondata> = arrayListOf()
        var q1=Questiondata(
                1,
                "1. Who invented C++?",
                "a) Dennis Ritchie",
                "b) Ken Thompson",
                "c) Brian Kernighan",
                "d) Bjarne Stroustrup",
                4

        )
        var q2=Questiondata(
                2,
                "2. What is C++?",
                "a) C++ is an object oriented programming language",
                "b) C++ is a procedural programming language",
                "c) C++ supports both procedural and object oriented programming language",
                "d) C++ is a functional programming language",
                3

        )
        var q3=Questiondata(
                3,
                "3. Which of the following is used for comments in C++?",
                "a) /* comment */",
                "b) // comment */",
                "c) // comment",
                "d) both // comment or /* comment */",
                4

        )
        var q4=Questiondata(
                4,
                "4. Which of the following is the correct syntax of including a user defined header files in C++?",
                "a) #include [userdefined]",
                "b) #include “userdefined”",
                "c) #include <userdefined.h>",
                "d) #include <userdefined>",
                2

        )
        var q5=Questiondata(
                5,
                "5. Which of the following user-defined header file extension used in c++?",
                "a) hg",
                "b) cpp",
                "c) h",
                "d) hf",
                3

        )

        var q6=Questiondata(
                6,
                "6. Which of the following is a correct identifier in C++?",
                "a) VAR_1234",
                "b) $ var_name",
                "c) 7VARNAME",
                "d) 7var_name",
                1

        )
        var q7=Questiondata(
                7,
                "7. Which of the following is not a type of Constructor in C++?",
                "a) Default constructor",
                "b) Parameterized constructor",
                "c) Copy constructor",
                "d) Friend constructor",
                1

        )
        var q8=Questiondata(
                8,
                "8. Which of the following approach is used by C++?",
                "a) Left-right",
                "b) Right-left",
                "c) Bottom-up",
                "d) Top-down",
                3

        )
        var q9=Questiondata(
                9,
                "9. What is virtual inheritance in C++?",
                "a) C++ technique to enhance multiple inheritance",
                "b) C++ technique to ensure that a private member of the base class can be accessed somehow",
                "c) C++ technique to avoid multiple inheritances of classes",
                "d) C++ technique to avoid multiple copies of the base class into children/derived class",
                4

        )
        var q10=Questiondata(
                10,
                "10. What happens if the following C++ statement is compiled and executed? \n" +
                        "int *ptr = NULL;\n" +
                        "delete ptr;\n",
                "a) The program is not semantically correct",
                "b) The program is compiled and executed successfully",
                "c) The program gives a compile-time error",
                "d) The program compiled successfully but throws an error during run-time",
                2

        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        que.add(q6)
        que.add(q7)
        que.add(q8)
        que.add(q9)
        que.add(q10)
        return que

    }

    fun getquestion_c():ArrayList<Questiondata>{
        var que:ArrayList<Questiondata> = arrayListOf()
        var q1=Questiondata(
                1,
                "1) What is the 16-bit compiler allowable range for integer constants?",
                "a)-3.4e38 to 3.4e38",
                "b)-32767 to 32768",
                "c)-32668 to 32667",
                "d)-32768 to 32767",
                4

        )
        var q2=Questiondata(
                2,
                "2) What is required in each C program?",
                "a)The program must have at least one function.",
                "b)The program does not require any function.",
                "c)Input data",
                "d)Output data",
                1

        )
        var q3=Questiondata(
                3,
                "3) What will this program print? \n" +
                        "main()  \n" +
                        "{  \n" +
                        "  int i = 2;  \n" +
                        "  {  \n" +
                        "    int i = 4, j = 5;  \n" +
                        "     printf(\"%d %d\", i, j);  \n" +
                        "  }    \n" +
                        "  printf(\"%d %d\", i, j);  \n" +
                        "} ",
                "a)4525",
                "b)2525",
                "c)4545",
                "d)None of the these",
                1

        )
        var q4=Questiondata(
                4,
                "4) Why is a macro used in place of a function?",
                "a)It reduces execution time.",
                "b)It reduces code size.",
                "c)It increases execution time.",
                "d)It increases code size.",
                4

        )
        var q5=Questiondata(
                5,
                "5) Which of the following comment is correct when a macro definition includes arguments?",
                "a)The opening parenthesis should immediately follow the macro name.",
                "b)There should be at least one blank between the macro name and the opening parenthesis.",
                "c)There should be only one blank between the macro name and the opening parenthesis.",
                "d)All the above comments are correct.",
                1

        )

        var q6=Questiondata(
                6,
                "6) What is a lint?",
                "a)C compiler",
                "b)Interactive debugger",
                "c)Analyzing tool",
                "d)C interpreter",
                3

        )
        var q7=Questiondata(
                7,

                "7) What is the output of this statement \"printf(\"%d\", (a++))\"?",
                "a) The value of (a + 1)",
                "b) The current value of a",
                "c) Error message",
                "d) Garbage",
                1
        )
        var q8=Questiondata(
                8,

                "8) Study the following program:\n" +
                        "\n" +
                        "main()  \n" +
                        "{  \n" +
                        "   char x [10], *ptr = x;  \n" +
                        "  scanf (\"%s\", x);  \n" +
                        "  change(&x[4]);  \n" +
                        "}  \n" +
                        " change(char a[])  \n" +
                        " {  \n" +
                        "   puts(a);  \n" +
                        " }  \n" +
                        "If abcdefg is the input, the output will be\n",
                "a)abcd",
                "b)abc",
                "c)efg",
                "d)Garbage",
                3

        )
        var q9=Questiondata(
                9,

                "9) Study the following program:\n" +
                        "\n" +
                        "main()  \n" +
                        "{  \n" +
                        "  int a = 1, b = 2, c = 3:  \n" +
                        "  printf(\"%d\", a + = (a + = 3, 5, a))  \n" +
                        "}  \n" +
                        "What will be the output of this program?",
                "a)6",
                "b)9",
                "c)12",
                "d)8",
                4
        )
        var q10=Questiondata(
                10,
                "10) What does this declaration mean?\n" +
                        "int x : 4; ",
                "a) X is a four-digit integer.",
                "b) X cannot be greater than a four-digit integer.",
                "c) X is a four-bit integer.",
                "d) None of the these",
                1

        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        que.add(q6)
        que.add(q7)
        que.add(q8)
        que.add(q9)
        que.add(q10)
        return que

    }


    fun getquestion_python():ArrayList<Questiondata>{
        var que:ArrayList<Questiondata> = arrayListOf()
        var q1=Questiondata(
                1,
                "1. Who developed Python Programming Language?",
                " Wick van Rossum",
                "Rasmus Lerdorf",
                "Guido van Rossum",
                " Niene Stom",
                3

        )
        var q2=Questiondata(
                2,
                "2. Which type of Programming does Python support?",
                " object-oriented programming",
                "structured programming",
                " functional programming",
                " all of the mentioned",
                4

        )
        var q3=Questiondata(
                3,
                "Is Python case sensitive when dealing with identifiers?",
                "no",
                "yes",
                "machine dependent",
                "none of the mentioned",
                1

        )
        var q4=Questiondata(
                4,
                "Which of the following is the correct extension of the Python file?",
                ".python",
                ".pl",
                ".py",
                ".p",
                3

        )
        var q5=Questiondata(
                5,
                " Is Python code compiled or interpreted?",
                " Python code is both compiled and interpreted",
                "Python code is neither compiled nor interpreted",
                "Python code is only compiled",
                "Python code is only interpreted",
                2

        )

        var q6=Questiondata(
                6,
                "6. All keywords in Python are in _________",
                "Capitalized",
                " lower case",
                " UPPER CASE",
                "None of the mentioned",
                4

        )
        var q7=Questiondata(
                7,

                "7. What will be the value of the following Python expression?\n4 + 3 % 5",
                " 7",
                "2",
                "4",
                "1",
                1
        )
        var q8=Questiondata(
                8,

                "8. Which of the following is used to define a block of code in Python language?",
                "Indentation",
                "Key",
                "Brackets",
                "All of the mentioned",
                1

        )
        var q9=Questiondata(
                9,

                "9. Which keyword is used for function in Python language?",
                "Function",
                "Def",
                "Fun",
                "Define",
                2
        )
        var q10=Questiondata(
                10,
                "10. Which of the following character is used to give single-line comments in Python?",
                "//",
                "#",
                "!",
                "/*",
                2

        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        que.add(q6)
        que.add(q7)
        que.add(q8)
        que.add(q9)
        que.add(q10)
        return que

    }






}