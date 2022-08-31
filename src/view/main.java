package view;

import javax.swing.*;
import controller.KillController;

public class main {
	static String soType, processo;

	public static void main(String[] args) {
		KillController kc = new KillController();
		int opc = 0;

		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(
					"1 - verificar SO \n2 - Exibir tabela \n3 - Encerrar processo via PID \n4 - Encerrar processo via nome \n9 - Encerrar programa"));
			switch (opc) {
			case 1:
				soType = getSoType(soType); System.out.println(soType);
				break;
			case 2:
				if (soType.contains("Windows")) { processo = "TASKLIST /FO TABLE"; } else { processo = "ps -ef"; } 
				kc.chamaProcesso(processo);
				break;
			case 3:
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID"));
				kc.mataProcessoPid(pid, soType);
				break;
			case 4:
				String name = JOptionPane.showInputDialog("Digite o nome do processo");
				kc.mataProcessoNome(name, soType);
				break;
			case 9:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
			}
		}

	}

	private static String getSoType(String so) {
		so = System.getProperty("os.name");
		return so;
	}
}
