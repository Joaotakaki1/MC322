import java.util.ArrayList;
import java.util.List;

public class Validacao {
    public static boolean verificaDigitosIguais(String cpf) {
        int n = cpf.length();
        char inicial = cpf.charAt(0);
        for (int i = 1; i < n; i++) {
            if (cpf.charAt(i) != inicial) {
                return false;
            }
        }
        return true;
    }

    public static boolean validaCNPJ(String cnpj) {
        String cnpjNumerico = cnpj.replaceAll("[^0-9]", "");
        if (cnpjNumerico.length() == 14) {
            if (verificaDigitosIguais(cnpjNumerico)) {
                return false;
            } else {
                List<Integer> list = new ArrayList<Integer>() {
                    {
                        add(6);
                        add(5);
                        add(4);
                        add(3);
                        add(2);
                        add(9);
                        add(8);
                        add(7);
                        add(6);
                        add(5);
                        add(4);
                        add(3);
                        add(2);
                    }
                };
                int soma1 = 0;
                int primeiroVerificador = 0;
                for (int i = 1; i < list.size(); i++) {
                    soma1 += list.get(i) * Character.digit(cnpjNumerico.charAt(i - 1), 10);
                }
                if (soma1 % 11 < 2)
                    primeiroVerificador = 0;
                else
                    primeiroVerificador = 11 - (soma1 % 11);
                if (primeiroVerificador == Character.digit(cnpjNumerico.charAt(12), 10)) {
                    int segundoVerificador = 0;
                    int soma2 = 0;
                    for (int i = 0; i < list.size(); i++) {
                        soma2 += list.get(i) * Character.digit(cnpjNumerico.charAt(i), 10);
                    }
                    if (soma2 % 11 < 2)
                        segundoVerificador = 0;
                    else
                        segundoVerificador = 11 - (soma2 % 11);
                    if (segundoVerificador == Character.digit(cnpjNumerico.charAt(13), 10))
                        return true;
                    else
                        return false;
                } else
                    return false;
            }
        } else {
            return false;
        }
    }

    public static boolean validaCPF(String cpf) {
        String cpfNumerico = cpf.replaceAll("[^0-9]", "");
        if (cpfNumerico.length() == 11) {
            if (verificaDigitosIguais(cpfNumerico)) {
                return false;
            } else {
                int primeiroVerificador = 0;
                int multiplicador = 2;
                for (int i = 8; i >= 0; i--) {
                    primeiroVerificador += Character.digit(cpfNumerico.charAt(i), 10) * multiplicador;
                    multiplicador++;
                }
                if (primeiroVerificador % 11 < 2) {
                    primeiroVerificador = 0;
                } else {
                    primeiroVerificador = 11 - (primeiroVerificador % 11);
                }
                if (primeiroVerificador == Character.digit(cpfNumerico.charAt(9), 10)) {
                    int segundoVerificador = 0;
                    int multiplicador2 = 2;
                    for (int j = 9; j >= 0; j--) {
                        segundoVerificador += Character.digit(cpfNumerico.charAt(j), 10) * multiplicador2;
                        multiplicador2++;
                    }
                    if (segundoVerificador % 11 < 2) {
                        segundoVerificador = 0;
                    } else {
                        segundoVerificador = 11 - (segundoVerificador % 11);
                    }
                    if (segundoVerificador == Character.digit(cpfNumerico.charAt(10), 10)) {
                        return true;
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    // public static boolean validaNome(String nome) {
    //     return nome.matches("[a-zA-Z]+");
    // }

}
