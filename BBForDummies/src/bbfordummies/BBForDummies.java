import java.util.*;
import java.io.*;
public class BBForDummies
{
	public static String[]Grup1;
	public static String[]Grup2;
	public static String[]GrupCompTemp;
	public static String[]Grup3;
	public static String[]MatricUnificadas;
	public static int[]Trimeada;
	public static int cuentafinal=0;
	public static void main(String[]args) throws IOException
	{
		String[]Grup1;
		int opcionElegida=0;
		int opcionElegida1=0;
		Scanner keyboard= new Scanner(System.in);
		do
		{
			System.out.print("");
			System.out.println("1. Ingresa matrículas del primer grupo.");
			System.out.println("2. Ingresa matrículas del segundo grupo.");
			System.out.println("3. Generar un grupo con las matrículas de ambos grupos.");
			System.out.println("4. Generar grupo con los alumnos que SÓLO estén en ambos grupos.");
			System.out.println("5. Mostrar todos los equipos posibles en algún grupo.");
			System.out.println("6. Generar todas las parejas de estudio posibles entre ambos grupos.");
			System.out.println("7. Generar todas las parejas de estudio posibles en un grupo.");
			System.out.println("8. Ordenar matrículas de algún grupo de manera ascendente.");
			System.out.println("9. Revisar si un grupo de matrículas pertenece parcialmente o por completo a alguno de los dos grupos.");
			System.out.println("10. Revisar si UNA matrícula pertenece a algún grupo");
			System.out.println("11. Salir del MEJOR BLACKBOARD PARA PROFESORES.");

			System.out.println();
			System.out.println("Ingresa el número de la opción que deseas el programa ejecute [1-11]");
			opcionElegida=keyboard.nextInt();
			System.out.print("");

			if(opcionElegida==1)
			{
				Grupo1();
				System.out.println("");
			}
			else if(opcionElegida==2)
			{
				Grupo2();
				System.out.println("");
			}
			else if(opcionElegida==3)
			{
				String[]LecturaGrup1=lecturaFilesArrays("GRUPOMAT1.txt");
				String[]LecturaGrup2=lecturaFilesArrays2("GRUPOMAT2.txt");
				for(int v=0;v<LecturaGrup1.length;v++)
				{
					System.out.println(LecturaGrup1[v].substring(0,9));
				}
				for(int l=0;l<LecturaGrup2.length;l++)
				{
					int cuenta= NoPresente(LecturaGrup1,LecturaGrup2[l]);
					int indice=0;
					if (cuenta==0)
					{
						String[]GrupCompTemp=new String[indice+1];
						GrupCompTemp[indice]=LecturaGrup2[l];
						System.out.println(GrupCompTemp[indice].substring(0,9));
						indice++;
					}
				}
			}
			else if(opcionElegida==4)
			{
				int i=0;
				String[]LecturaGrup1=lecturaFilesArrays("GRUPOMAT1.txt");
				String[]LecturaGrup2=lecturaFilesArrays2("GRUPOMAT2.txt");
				System.out.print("[");
				for(int v=0;v<LecturaGrup1.length;v++)
				{
					for(int w=0;w<LecturaGrup2.length;w++)
					{
						if(LecturaGrup1[v].equals(LecturaGrup2[w]))
						{
							System.out.print(LecturaGrup1[v]+"");
						}
					}
				}
				System.out.print("]");
				System.out.println("");
				System.out.println("");
			}
			else if(opcionElegida==5)
			{
				String[]LecturaGrup1=lecturaFilesArrays("GRUPOMAT1.txt");
				String[]LecturaGrup2=lecturaFilesArrays2("GRUPOMAT2.txt");
				System.out.println("Con que grupo deseas aplicar esta función?");
				opcionElegida1=keyboard.nextInt();
				System.out.print("");
				if (opcionElegida1==1)
				{
					for(int t=1;t<=LecturaGrup1.length;t++)
						{
						printCombination(LecturaGrup1,LecturaGrup1.length,t);
						System.out.println("");
						}
				}
				else if(opcionElegida1==2)
				{	for(int t=1;t<=LecturaGrup1.length;t++)
					printCombination(LecturaGrup2,LecturaGrup2.length,t);
					System.out.println("");
				}
			}
			else if(opcionElegida==6)
			{
				String[]LecturaGrup1=lecturaFilesArrays("GRUPOMAT1.txt");
				String[]LecturaGrup2=lecturaFilesArrays2("GRUPOMAT2.txt");
				Combinaciones(LecturaGrup1,LecturaGrup2);
			}
			else if(opcionElegida==7)
			{
				String[]LecturaGrup1=lecturaFilesArrays("GRUPOMAT1.txt");
				String[]LecturaGrup2=lecturaFilesArrays2("GRUPOMAT2.txt");
				System.out.println("Con que grupo deseas aplicar esta función?");
				opcionElegida1=keyboard.nextInt();
				System.out.print("");
				if (opcionElegida1==1)
				{
					printCombination(LecturaGrup1,LecturaGrup1.length,2);
					System.out.println("");
				}
				else if(opcionElegida1==2)
				{
					printCombination(LecturaGrup2,LecturaGrup2.length,2);
					System.out.println("");
				}
			}
			else if(opcionElegida==8)
			{
				System.out.println("Con que grupo deseas aplicar esta función?");
				opcionElegida1=keyboard.nextInt();
				System.out.print("");
				if (opcionElegida1==1)
				{
					String[]Ordenados1=Trimeada("GRUPOMAT1.txt");
					TrimeadaOrdenada(Ordenados1);
					System.out.println("");
				}
				else if(opcionElegida1==2)
				{
					String[]Ordenados2=Trimeada("GRUPOMAT2.txt");
					TrimeadaOrdenada(Ordenados2);
					System.out.println("");
				}
			}
			else if(opcionElegida==9)
			{
				String[]LecturaGrup1=lecturaFilesArrays("GRUPOMAT1.txt");
				String[]LecturaGrup2=lecturaFilesArrays2("GRUPOMAT2.txt");
				String[]LecturaGrup3=lecturaFilesArrays3("GRUPOMATPERTENENCIA.txt");
				for(int f=0;f<LecturaGrup3.length;f++)
				{
					String matriculaAnalizar=LecturaGrup3[f];
					boolean grupo1;
					boolean grupo2;
					int bandera=0;
					grupo1=Pertenencia(LecturaGrup1,matriculaAnalizar);
					grupo2=Pertenencia(LecturaGrup2,matriculaAnalizar);
					if(grupo1&&grupo2)
					{
					bandera=0;
					cuentafinal=cuentafinal+bandera;
					System.out.println(matriculaAnalizar+" pertence a ambos grupos");
					}
					else if(grupo1&&grupo2==false)
					{
					bandera=2;
					cuentafinal=cuentafinal+bandera;
					System.out.println(matriculaAnalizar+" pertence al grupo 1");
					}
					else if(grupo2&&grupo1==false)
					{
					bandera=2;
					cuentafinal=cuentafinal+bandera;
					System.out.println(matriculaAnalizar+" pertence al grupo 2");
					}
					else
					{
					bandera=1000;
					cuentafinal=cuentafinal+bandera;
					System.out.println(matriculaAnalizar+" no pertenece a ninguno de ambos grupos");
					}
				}
				if(cuentafinal==0)
					System.out.println("Las matrículas se encuentran en ambos grupos");
				else if((cuentafinal<(LecturaGrup3.length*1000))&&(cuentafinal>0))
					System.out.println("Las matrículas se encuentran parcialmente en ambos grupos");
				else
				{
					System.out.println("Las matrículas no se encuentran en ninguno de ambos ambos grupos");
				}
				System.out.println();
			}
			else if(opcionElegida==10)
			{
				String[]LecturaGrup1=lecturaFilesArrays("GRUPOMAT1.txt");
				String[]LecturaGrup2=lecturaFilesArrays2("GRUPOMAT2.txt");
				System.out.println("Ingresa la matrícula a buscar");
				String matriculaAnalizar=keyboard.next();
				boolean grupo1;
				boolean grupo2;
				grupo1=Pertenencia(LecturaGrup1,matriculaAnalizar);
				grupo2=Pertenencia(LecturaGrup2,matriculaAnalizar);
				if(grupo1&&grupo2)
					System.out.println("La matrícula se encuentra en ambos grupos");
				else if(grupo1&&grupo2==false)
					System.out.println("La matrícula se encuentra en Sólo en el grupo 1");
				else if(grupo2&&grupo1==false)
					System.out.println("La matrícula se encuentra en Sólo en el grupo 2");
				else
					System.out.println("La matrícula no se encuntra en ningún grupo");
			}
			System.out.println();
		}
		while(opcionElegida!=11);
	}

	public static void Grupo1() throws IOException
	{
		System.out.print("[");
		File Grupo1= new File("GRUPOMAT1.txt");
		Scanner fromFile= new Scanner(Grupo1);
		while(fromFile.hasNext())
		{
			System.out.print(fromFile.next());
		}
		fromFile.close();
		System.out.print("]");
		System.out.println();
	}
	public static void Grupo2() throws IOException
	{
		System.out.print("[");
		File Grupo2= new File("GRUPOMAT2.txt");
		Scanner fromFile1= new Scanner(Grupo2);
		while(fromFile1.hasNext())
		{
			System.out.print(fromFile1.next()+"");
		}
		fromFile1.close();
		System.out.print("]");
		System.out.println();
	}
	public static String[] lecturaFilesArrays(String file)
	{
		int control=0;
		try
		{
			Scanner theFile= new Scanner(new File(file));
			while(theFile.hasNext())
			{
				control=control+1;
				theFile.next();
			}
			String[]Grupo1= new String[control];
			Scanner theFile1= new Scanner(new File(file));
			for(int i=0;i<control;i++)
			{
				Grupo1[i]=(theFile1.next());
			}
			return Grupo1;
		}
		catch(FileNotFoundException e)
		{
		}
		return null;
	}
	public static String[] lecturaFilesArrays2(String file)
	{
		int control=0;
		try
		{
			Scanner theFile= new Scanner(new File(file));
			while(theFile.hasNext())
			{
				control=control+1;
				theFile.next();
			}
			String[]Grupo2= new String[control];
			Scanner theFile2= new Scanner(new File(file));
			for(int i=0;i<control;i++)
			{
				Grupo2[i]=(theFile2.next());
			}
			return Grupo2;
		}
		catch(FileNotFoundException e)
		{
		}
		return null;
	}
	public static String[] lecturaFilesArrays3(String file)
		{
			int control=0;
			try
			{
				Scanner theFile= new Scanner(new File(file));
				while(theFile.hasNext())
				{
					control=control+1;
					theFile.next();
				}
				String[]Grupo3= new String[control];
				Scanner theFile2= new Scanner(new File(file));
				for(int i=0;i<control;i++)
				{
					Grupo3[i]=(theFile2.next());
				}
				return Grupo3;
			}
			catch(FileNotFoundException e)
			{
			}
		return null;
	}
	public static int NoPresente(String[] array, String string)
	{
		int cuentafinal=0;
		for(int b=0;b<array.length;b++)
		{
			if(array[b].equals(string))
			{
				cuentafinal=cuentafinal+1000;
			}
		}
		return cuentafinal;
	}
	static void combinationUtil(String arr[], String data[], int inicio, int finall, int indice, int value)
	{
		if (indice== value)
		{
			for (int j=0;j<value;j++)
					System.out.print(data[j].substring(0,9)+ " ");
			System.out.println("");
			return;
		}
		for (int i=inicio;i<=finall && finall-i+1>=value-indice;i++)
			{
				data[indice]=arr[i];
				combinationUtil(arr,data,i+1,finall,indice+1,value);
			}
		}
		static void printCombination(String arr[], int longitud, int tamañoComb)
		{
			String data[]=new String[tamañoComb];
			combinationUtil(arr, data, 0, longitud-1, 0, tamañoComb);
		}
	public static void Combinaciones(String arr[],String arr2[])
	{
		int length=arr.length;
		int length2=arr2.length;
		int insidecounter=0;
		for(int t=0;t<length;t++)
		{
			for(int s=0;s<length2;s++)
			{
				if(!(arr[t].substring(0,9).equals(arr2[s].substring(0,9))))
				{
					System.out.println(arr[t].substring(0,9)+" "+arr2[s].substring(0,9));
				}
			}
		}
	}
	public static String[] Trimeada (String file)
	{
			int control=0;
			try
			{
				Scanner theFile= new Scanner(new File(file));
				while(theFile.hasNext())
				{
					control=control+1;
					theFile.next();
				}
				String[]Grupo1= new String[control];
				Scanner theFile1= new Scanner(new File(file));
				String[]Trimeada= new String[control];
				for(int i=0;i<control;i++)
				{
					Grupo1[i]=(theFile1.next());
					String mat=Grupo1[i].substring(1,9);
					int matNum= Integer.parseInt(mat);
					Trimeada[i]=("a0"+matNum);
				}
				return Trimeada;
			}
			catch(FileNotFoundException e)
			{
			}
			return null;
	}
	public static void TrimeadaOrdenada (String[] array)
	{
		int length= array.length;
		Arrays.sort(array,0,length);
		for(String matricula : array)
		System.out.println(matricula);
	}
	public static boolean Pertenencia(String[] array, String matriculaAnalizar)
	{
		boolean grupo1=true;
		for(int x=0;x<array.length;x++)
		{
			if(matriculaAnalizar.equals(array[x].substring(0,9)))
			{
				grupo1=true;
				break;
			}
			else
				grupo1=false;
		}
		return grupo1;
	}
}