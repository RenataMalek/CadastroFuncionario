import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GestaoFuncionario {

	Funcionario[] funcionarios = new Funcionario[50];
	int indice = 0;

	public static void main(String[] args) throws ParseException {

		GestaoFuncionario f1 = new GestaoFuncionario();

		for (int j = 0; j < f1.funcionarios.length; j++) {
			f1.funcionarios[j] = new Funcionario();
		}

		f1.menu();
		
		

	}

	public void criar() {

		funcionarios[indice].id = indice;
		funcionarios[indice].nome = JOptionPane.showInputDialog("Nome: ");
		funcionarios[indice].matricula = JOptionPane.showInputDialog("Matricula: ");

		funcionarios[indice].admissao = JOptionPane.showInputDialog("Data de admiss�o: ");

		funcionarios[indice].demissao = JOptionPane.showInputDialog("Data de demiss�o: ");

		funcionarios[indice].salario = Float.parseFloat(JOptionPane.showInputDialog("Sal�rio: "));
		funcionarios[indice].horario = JOptionPane.showInputDialog("Hor�rio: ");

		JOptionPane.showMessageDialog(null, "Funcion�rio cadastrado com sucesso!!");

		indice++;

	}

	void exibir(String matricula) {

		int i;
		
		try {
		for (i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i].matricula.equalsIgnoreCase(matricula)) {

				long id = funcionarios[i].id;
				String nome = funcionarios[i].nome;
				String admissao = funcionarios[i].admissao;
				String demissao = funcionarios[i].demissao;
				float salario = funcionarios[i].salario;
				String horario = funcionarios[i].horario;

				JOptionPane.showMessageDialog(null,
						"ID: " + id + "\nMatricula: " + matricula + "\nNome: " + nome + "\nData admiss�o: " + admissao
								+ "\nData demissao: " + demissao + "\nSalario" + salario + "\nHorario: " + horario);
				break;
			}
		}

		if (i == (funcionarios.length)) {
			System.out.println("Nenhum dado foi encontrado!");
		}
		}catch(Exception e) {
			System.out.println("\nN�o foi possivel localizar, tente novamente ou escolha outra op��o\n");
		}
	}

	void atualizar(String matricula) {

		int i;

		try {

			for (i = 0; i < funcionarios.length; i++) {
				if (funcionarios[i].matricula.equalsIgnoreCase(matricula)) {
					JOptionPane.showMessageDialog(null, "Atualize os dados:");
					funcionarios[i].nome = JOptionPane.showInputDialog("Nome: ");
					funcionarios[i].admissao = JOptionPane.showInputDialog("Data de admiss�o: ");
					funcionarios[i].demissao = JOptionPane.showInputDialog("Data de demiss�o: ");
					funcionarios[i].salario = Float.parseFloat(JOptionPane.showInputDialog("Sal�rio: "));
					funcionarios[i].horario = JOptionPane.showInputDialog("Hor�rio: ");

					break;
				}
			}
			if (i == (funcionarios.length)) {
				System.out.println("Funcionario n�o cadastrado!");
			}
		} catch (Exception e) {
			System.out.println("\nN�o foi possivel localizar, tente novamente ou escolha outra op��o\n");
		}

	}

	void remover(String matricula) {

		int i;

		try {
			for (i = 0; i < funcionarios.length; i++) {
				if (funcionarios[i].matricula.equalsIgnoreCase(matricula)) {

					funcionarios[i] = null;
					JOptionPane.showMessageDialog(null, "Funcionario excluido do sistema");
					break;
				}
			}

			if (i == (funcionarios.length)) {
				System.out.println("Nenhum dado foi encontrado!");
			}
		} catch (Exception e) {
			System.out.println("\nN�o foi possivel localizar, tente novamente ou escolha outra op��o\n");
		}
	}

	void menu() {
		String opc = "";
		Scanner scan = new Scanner(System.in);
		String matricula = "";

		while (opc != "S") {
			System.out.println("***Bem Vindo*** \nDigite a op��o desejada: \n1 - (C)riar \n2 - (A)tualizar \n3 - "
					+ "(E)xibir \n4 - (R)emover \n9 - (S)air");

			opc = scan.nextLine().toUpperCase();

			switch (opc) {
			case "C":
				criar();
				break;
			case "A":
				matricula = JOptionPane.showInputDialog("Digite o numero da matricula do funcionario: ");
				atualizar(matricula);
				break;
			case "R":
				matricula = JOptionPane.showInputDialog("Digite o numero da matricula do funcionario: ");
				remover(matricula);
				break;
			case "E":
				matricula = JOptionPane.showInputDialog("Digite o numero da matricula do funcionario: ");
				exibir(matricula);
				break;
			case "S":
				JOptionPane.showMessageDialog(null, "Fim");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Op��o inv�lida, tente novamente");
			}
		}

		scan.close();
	}
	
}
