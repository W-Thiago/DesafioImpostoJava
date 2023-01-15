package app;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double rendaAnual = 0;
        double rendaPrestServico = 0;
        double ganhoCapital = 0;
        double gMedico = 0;
        double gEducacionais = 0;

        double salarioMensal = 0;
        double impostoSalario = 0;
        double impostoService = 0;
        double impostoCapital = 0;
        double impostoBruto = 0;
        double maxDedutivel = 0;
        double gastosDedutiveis = 0;
        double Abatimento = 0;

        System.out.print("digite dois exemplos: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("exemplo: " + i);
            System.out.print("Renda anual com salário: ");
            rendaAnual = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            rendaPrestServico = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            ganhoCapital = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            gMedico = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            gEducacionais = sc.nextDouble();
            System.out.println();

            System.out.println();
            System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
            System.out.println();

            salarioMensal = rendaAnual / 12;

            if (salarioMensal < 3000) {
                impostoSalario = 0.0;
            } else if (salarioMensal >= 3000 && salarioMensal < 5000) {
                impostoSalario += salarioMensal * 0.1 * 12;
            } else {
                impostoSalario = salarioMensal * 0.2 * 12;
            }

            System.out.println("CONSOLIDADO DE RENDA:");
            System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);

            if (rendaPrestServico == 0) {
                impostoService = 0;
            } else if (rendaPrestServico > 0) {
                impostoService = rendaPrestServico * 0.15;
            }

            System.out.printf("Imposto sobre serviços: %.2f%n", impostoService);

            if (ganhoCapital == 0) {
                impostoCapital = 0;
            } else if (ganhoCapital > 0) {
                impostoCapital = ganhoCapital * 0.2;
            }
            System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoCapital);

            System.out.println();
            System.out.println("DEDUÇÕES: ");


            impostoBruto = impostoSalario + impostoService + impostoCapital;
            maxDedutivel = impostoBruto * 0.3;  //----
            System.out.printf("Máximo dedutível: %.2f%n ", maxDedutivel);

            gastosDedutiveis = gMedico + gEducacionais;  //----
            System.out.printf("Gastos dedutíveis: %.2f%n", gastosDedutiveis);

            System.out.println();
            System.out.println("RESUMO: ");
            System.out.printf("imposto bruto: %.2f%n", impostoBruto);

            if (gastosDedutiveis > maxDedutivel) {
                Abatimento = maxDedutivel;
            } else {
                Abatimento = gastosDedutiveis;
            }
            System.out.printf("abatimentos: %.2f%n", Abatimento);
            System.out.printf("Imposto devido: %.2f%n", impostoBruto - Abatimento);
            System.out.println();
        }
        sc.close();
    }
}
