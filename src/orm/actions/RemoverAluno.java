package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class RemoverAluno {
	public static void main(String[] args) {
        Aluno aluno = new Aluno();
		Scanner sc = new Scanner(System.in);
        
        try {
			
        	System.out.println("Digite o ID do aluno: ");
        	aluno.setId(sc.nextLong());
        	
        	EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        	EntityManager manager = factory.createEntityManager();
        	
        	aluno = manager.find(Aluno.class, aluno.getId());
        	if (aluno != null) {
        		
        		manager.getTransaction().begin();
        		manager.remove(aluno);
        		manager.getTransaction().commit();
        		
        		System.out.println("Aluno Excluido");
        	}else {
        		System.out.println("Aluno não encontrado");
        	}
        	manager.close();
        	factory.close();
		} catch (Exception e) {
			System.out.println("Valor Invalido");
		}
        sc.close();
        
    }
}
