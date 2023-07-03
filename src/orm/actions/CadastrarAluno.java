package orm.actions;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class CadastrarAluno {
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite as informações do aluno a ser cadastrado:\n");
		
		System.out.println("Nome: ");
		aluno.setNome(sc.nextLine());
		
		System.out.println("CPF: ");
		aluno.setCPF(sc.nextLine());
		
		System.out.println("Email: ");
		aluno.setEmail(sc.nextLine());
		
		System.out.println("Endereço: ");
		aluno.setEndereco(sc.nextLine());
		
		System.out.println("Naturalidade: ");
		aluno.setNaturalidade(sc.nextLine());
		
		System.out.println("DataNascimento: ");
		aluno.setDataNascimento(sc.nextLine());
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno cadastrado, ID: "+aluno.toString());
		
		sc.close();
        manager.close();
        factory.close();
	}
}
