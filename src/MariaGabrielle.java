import java.time.LocalDate;
import java.time.Period;

public class MariaGabrielle {

    public static void main(String[] args) {
        // Data do início do namoro
        LocalDate dataNamoro = LocalDate.of(2024, 12, 16);

        // Obter cronômetro
        String cronometro = obterCronometro(dataNamoro);

        // Obter mensagem especial
        String mensagem = obterMensagemEspecial(dataNamoro);

        // Gerar e exibir página HTML no console
        String paginaHTML = gerarPaginaHTML(cronometro, mensagem);
        System.out.println(paginaHTML);
    }

    // Método para calcular o cronômetro
    public static String obterCronometro(LocalDate dataNamoro) {
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataNamoro, dataAtual);
        return String.format("%d anos, %d meses, %d dias",
                periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }

    // Método para obter mensagem especial
    public static String obterMensagemEspecial(LocalDate dataNamoro) {
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.getDayOfMonth() == 16) {
            if (dataAtual.getMonthValue() == dataNamoro.getMonthValue() && dataAtual.getYear() > dataNamoro.getYear()) {
                return "Feliz aniversário de namoro! Nosso amor é eterno e floresce a cada ano! 💖";
            }
            return "Hoje é dia 16! Mais um mês de momentos inesquecíveis juntos. 💕";
        }
        return "A cada dia ao seu lado, sinto que nosso amor só cresce. ❤️";
    }

    // Método para gerar a página HTML
    public static String gerarPaginaHTML(String cronometro, String mensagem) {
        return String.format("""
            <!DOCTYPE html>
            <html lang="pt-br">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Cronômetro do Amor</title>
                <style>
                    body { 
                        background-color: pink; 
                        text-align: center; 
                        font-family: Arial, sans-serif; 
                    }
                    .cronometro { 
                        font-size: 2em; 
                        color: #6B0A18; 
                        margin-top: 20px; 
                    }
                    .mensagem { 
                        font-size: 1.5em; 
                        color: #FF69B4; 
                        margin-top: 20px; 
                    }
                </style>
            </head>
            <body>
                <h1>Cronômetro do Amor</h1>
                <div class="cronometro">%s</div>
                <div class="mensagem">%s</div>
            </body>
            </html>
        """, cronometro, mensagem);
    }
}
