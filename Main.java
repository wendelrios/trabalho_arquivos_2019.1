package trabalho1;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception{
		
		int contador = 0;
		long meio, fim, inicio=0;
		String cep_procurado = "20921030";
			
		
		Endereco endereco = new Endereco();
		Scanner scan = new Scanner(System.in);
		
		
		 try {
			 	RandomAccessFile f = new RandomAccessFile("/Users/wendel/Documents/faculdade/organizacao_estrutura_arquivos/cep_arquivo/cep_ordenado.dat","r");
			 	fim = (f.length()/endereco.getTamanho())-1;
		        while( inicio <= fim) // para Detectar EOF
		        {
		        	contador++;
		        	meio = fim/2;
		        	f.seek(meio*endereco.getTamanho());
		            endereco.leEndereco(f);
		            if(endereco.getCep().equals(cep_procurado)) {
		            	System.out.println("CEP buscado encontrado");
		            	System.out.println("Iteracoes: "+contador);
		            }else if(endereco.getCep().compareTo(cep_procurado)>0) {
		            	fim = meio -1;
		            }else if(endereco.getCep().compareTo(cep_procurado)<0) {
		            	inicio  = meio+1;
		            }
		        }
		        	f.close();
		} catch (Exception e) {
			e.getMessage();
		}
	         
	       

	}

}
