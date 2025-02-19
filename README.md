# MenuSom - Gerenciador de Áudio para Aplicações Java

## Descrição
A classe `MenuSom` é uma implementação em Java que gerencia a reprodução de sons em aplicações, como jogos ou interfaces multimídia. Ela utiliza a biblioteca `javax.sound.sampled` para manipulação de áudio e `javax.swing` para criar uma interface gráfica simples que permite ao usuário selecionar diferentes trilhas sonoras.

## Funcionalidades
- **Carregamento de Sons**: Carrega diversos tipos de sons, como música de fundo, sons de botões, acertos, erros, vitórias, etc.
- **Reprodução de Sons**: Métodos para reproduzir sons específicos, como acertos, erros, cliques de botões, etc.
- **Interface Gráfica**: Uma interface simples para selecionar diferentes trilhas sonoras.
- **Singleton Pattern**: Garante que apenas uma instância da classe seja criada.

## Como Usar

### Instanciação**: Use `MenuSom.getInstance()` para obter a instância única da classe.
```java
private static MenuSom instance; // Instância única
    private Clip backgroundTheme;
    private Clip somBotao;
    private Clip acerto;
    private Clip erro;
    private Clip vitoriaBASED;
    private Clip vitoriaNotBASED;
    private Clip vitoriaAiMamae;
    private Clip vitoriaSeloko;
    private Clip somCarta;
    private Clip virarCartas;
    private final String LofiHipHop = "LofihiphopMix.wav";
    private final String LofiJAzz = "AfternoonJAZZ.wav";
    private final String MemoriesofGreen = "MemoriesOfGreen.wav";
    private final String MemoryReboot = "memoryReboot.wav";
    private final String Synthwave = "Synthwave.wav";
    private final String Omaweamu = "omaweamu.wav";

    // Construtor privado para evitar instanciação externa
    private MenuSom() {
        carregarSom(LofiHipHop);
        carregarSomBotao();
        carregarSomAcerto();
        carregarSomErro();
        carregarSomVitoria();
        carregarSomCarta();
        carregarSomVirarCartas();
        carregarSomVitoriaNotBased();
        carregarSomVitoriaAiMamae();
        carregarSomSeloko();
    }

 // Método para obter a instância única
    public static MenuSom getInstance() {
        if (instance == null) {
            instance = new MenuSom();
        }
        return instance;
    }

//Instanciando em uma classe qualquer do jogo
private MenuSom menuSom = MenuSom.getInstance();

//Fazendo a veririficação da instancia da classe
 if (menuSom != null) {
            menuSom.startBackgroundMusic();
        }
```

### Carregar Sons: Utilize métodos como `carregarSom(String audioFile)` para carregar arquivos de áudio.
```java
//Exemplo do carregar som da música de fundo
public void carregarSom(String audioFile) {
        try (InputStream backgroundThemeStream = getClass().getResourceAsStream("/sons/" + audioFile)) {
            if (backgroundThemeStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: " + audioFile);
            }
            // Usando BufferedInputStream para suportar mark/reset
            BufferedInputStream bufferedStream = new BufferedInputStream(backgroundThemeStream);
            AudioInputStream backgroundThemeAIS = AudioSystem.getAudioInputStream(bufferedStream);
            backgroundTheme = AudioSystem.getClip();
            backgroundTheme.open(backgroundThemeAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio: " + audioFile, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
//Métodos para tocar e parar a música de fundo
 public void stopBackgroundMusic() {
        if (backgroundTheme != null) {
            backgroundTheme.stop();
        }
    }

    public void startBackgroundMusic() {
        if (backgroundTheme != null) {
            backgroundTheme.start();
            backgroundTheme.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
//Padrao para som de botao
 public void carregarSomBotao() {
        try (InputStream somBotaoStream = getClass().getResourceAsStream("/sons/ui-button-click-4-284571.wav")) {
            if (somBotaoStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: ui-button-click-4-284571.wav");
            }
            // Usando BufferedInputStream para suportar mark/reset
            BufferedInputStream bufferedStream = new BufferedInputStream(somBotaoStream);
            AudioInputStream somBotaoAIS = AudioSystem.getAudioInputStream(bufferedStream);
            somBotao = AudioSystem.getClip();
            somBotao.open(somBotaoAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

//Os metodos restantntes seguem a mesma linha de raciocinio, tocar, parar...

```
### Reproduzir Sons: Use métodos como `playSomAcerto()`, `playButtonSound()`, etc., para reproduzir os sons carregados.
```java
 public void playButtonSound() {
        stopBackgroundMusic();
        if (somBotao != null) {
            somBotao.setFramePosition(0); // Rewind to the beginning
            somBotao.start();
        }
    }

    public void playButtonSound2() {
        stopBackgroundMusic();
        if (somBotao != null) {
            somBotao.setFramePosition(0); // Rewind to the beginning
            somBotao.start();
        }
        startBackgroundMusic();
    }
```
### Interface Gráfica: Chame `selecionarNovoSom()` para abrir uma janela onde o usuário pode selecionar uma nova trilha sonora.
```java
 public void selecionarNovoSom() {
        JFrame frame = new JFrame();
        frame.setTitle("Menu Som");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(800, 600); // Define o tamanho do JFrame
        frame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(6, 1, 11, 11));

        JButton lofi = criarBotao("Lofi/Atual", Color.CYAN);
        lofi.addActionListener(e -> {
            carregarSom(LofiHipHop);
            frame.dispose();
            new Jogo();
        });
        panel.add(lofi);

        JButton jazz = criarBotao("Jazz-Lofi", Color.YELLOW);
        jazz.addActionListener(e -> {
            carregarSom(LofiJAzz);
            frame.dispose();
            new Jogo();
        });
        panel.add(jazz);

        JButton green = criarBotao("Memories Of Green", Color.GREEN);
        green.addActionListener(e -> {
            carregarSom(MemoriesofGreen);
            frame.dispose();
            new Jogo();
        });
        panel.add(green);

        JButton memory = criarBotao("Memory Reboot - VOJ & NARVENT", Color.BLACK);
        memory.addActionListener(e -> {
            carregarSom(MemoryReboot);
            frame.dispose();
            new Jogo();
        });
        panel.add(memory);

        JButton synth = criarBotao("Synthwave", Color.MAGENTA);
        synth.addActionListener(e -> {
            carregarSom(Synthwave);
            frame.dispose();
            new Jogo();
        });
        panel.add(synth);

        JButton omaweamu = criarBotao("Omaweamu", Color.PINK);
        omaweamu.addActionListener(e -> {
            carregarSom(Omaweamu);
            frame.dispose();
            new Jogo();
        });
        panel.add(omaweamu);

        panel.setBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

//Essa interface é criada por meio de uma função private JButton criarBotao(String texto, Color cor) que será mostrada na main do jogo pois ambas são iguais.
```

# Jogo - Interface Gráfica para Seleção de Elementos

## Descrição
A classe `Jogo` representa a interface gráfica principal do aplicativo, permitindo a seleção de diferentes categorias de elementos químicos através de botões interativos. A interface é baseada na biblioteca `javax.swing`, e a música de fundo é gerenciada pela classe `MenuSom`.

## Funcionalidades
- **Interface Gráfica com Botões**: Disponibiliza botões interativos para navegar entre diferentes categorias de elementos químicos.
- **Integração com `MenuSom`**: Reproduz sons de clique nos botões e música de fundo.
- **Disposição em Grade**: Organiza os botões em um layout estruturado para facilitar a navegação.
- **Encerramento da Aplicação**: O botão "Sair" fecha o programa ao ser pressionado.

## Como Usar
1. **Execução**: A classe `Jogo` pode ser iniciada diretamente chamando `new Jogo();` na `main`.
2. **Navegação**: Clique nos botões para abrir novas janelas correspondentes às categorias de elementos.
3. **Interação com Sons**: Sons de clique são reproduzidos ao pressionar os botões.
4. **Encerramento**: Clique no botão "Sair" para fechar a aplicação.

## Função que cria os Botôes:
```java
private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.setPreferredSize(new Dimension(200, 200)); // Botão quadrado e menor
        botao.setBackground(cor);  // Definir a cor de fundo
        botao.setForeground(Color.WHITE); // Cor do texto
        botao.setFocusPainted(false); // Remove o foco
        botao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Borda preta
        botao.setOpaque(true); // Para garantir que a cor de fundo seja visível
        return botao;
    }
```


# Classe Modelo para Jogos da Memória

## Descrição
A classe `Gas` é um modelo para um jogo da memória em Java usando `Swing` para a interface gráfica. Ela segue um padrão reutilizável, onde o nome da classe pode mudar, assim como a quantidade e os nomes das cartas, mas a estrutura geral do código permanece a mesma.

## Estrutura da Classe
A classe contém diversos componentes gráficos e variáveis de controle:

### Classe Interna `Carta`
Define uma carta do jogo com nome e imagem associada.

```java
class Carta {
    String nomeCarta;
    ImageIcon iconeCarta;

    Carta(String nomeCarta, ImageIcon iconeCarta) {
        this.nomeCarta = nomeCarta;
        this.iconeCarta = iconeCarta;
    }

    public String toString() {
        return nomeCarta;
    }
}
```
**Representa** uma carta do jogo.

**Contém** um nome (nomeCarta) e uma imagem (iconeCarta).

**O** método toString() retorna apenas o nome da carta.

### Lista de Cartas (`cardList`)
Define os elementos utilizados no jogo da memória, podendo ser alterados para diferentes categorias.
```java
String[] cardList = {
            "argonio",
            "cripton",
            "helio",
            "hidrogenio",
            "neon",
            "radonio",
            "xenonio"
    };
```
**Define** as cartas utilizadas no jogo.

**Essa** lista pode variar em outras classes baseadas neste modelo.

### Configuração do Tabuleiro
Define o número de linhas e colunas do tabuleiro do jogo.
```java
int linha = 2;
int coluna = 7;
int cartaLargura = 90;
int cartaAltura = 128;
```
**Define** o layout do tabuleiro.

**O jogo** possui 2 linhas e 7 colunas, mas isso pode mudar dependendo da variação do modelo.

### Elementos de Controle do Jogo
Inclui contadores de acertos, erros e status do jogo.
```java
int totalDePares = cardList.length;
int contadorAcertos = 0;
int contadorDeErros = 0;
boolean jogoPronto = false;
```
**totalDePares**: Número total de pares no jogo.

**contadorAcertos**: Guarda o número de pares encontrados.

**contadorDeErros**: Conta os erros do jogador.

**jogoPronto**: Indica se o jogo já pode começar.

## Interface Gráfica (`Swing`)
A classe gerencia a janela principal do jogo, botões, labels de texto e painel para exibição das cartas.
```java
JFrame frame = new JFrame("Metais Alcalinos e Alcalinos Terrosos");
JLabel textoLabel = new JLabel();
JLabel tempoLabel = new JLabel("Tempo: 0s");
JPanel textoPanel = new JPanel();
JPanel bordaPanel = new JPanel();
JPanel buttonPanel = new JPanel();
JButton restartGameButton = new JButton("Reiniciar Jogo");
JButton voltarButton = new JButton("Voltar");
```
**frame**: Janela principal do jogo.

**textoLabel**: Exibe o número de acertos e erros.

**tempoLabel**: Exibe o tempo decorrido.

**bordaPanel**: Contém as cartas do jogo.

**buttonPanel**: Contém os botões de reiniciar e voltar.

### Configuração da Janela
```java
frame.setLayout(new BorderLayout());
frame.setBounds(450, 200, bordaLargura, bordaAltura);
frame.setResizable(false);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```
**Define** a posição e o tamanho da janela.

**Impede** o redimensionamento da janela.

**Configura** a ação ao fechar (EXIT_ON_CLOSE).


## Lógica do Jogo

### Carregar Cartas
Obtém as imagens das cartas e duplica a lista para formar pares.

```java
void mostrarCarta() {
    deckCarta = new ArrayList<>();
    for (String nomeCarta : cardList) {
        URL resourceUrl = getClass().getResource("/gas/" + nomeCarta + ".jpg");
        if (resourceUrl == null) {
            System.err.println("Erro: Imagem não encontrada - " + nomeCarta + ".jpg");
            continue;
        }
        Image imagemCarta = new ImageIcon(resourceUrl).getImage();
        ImageIcon iconeCarta = new ImageIcon(imagemCarta.getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH));
        deckCarta.add(new Carta(nomeCarta, iconeCarta));
    }
    deckCarta.addAll(deckCarta);
}
```
**Carrega** as imagens das cartas com base nos nomes da cardList.

**Cada** carta tem um par idêntico (duplicação da lista deckCarta).

**As** imagens devem estar na pasta /gas(exemplo utilizado)/.

### Misturar Cartas
Embaralha a ordem das cartas no tabuleiro.

```java
void misturarCarta() {
    menuSom.playSomVirarCartas();
    for (int i = 0; i < deckCarta.size(); i++) {
        int j = (int) (Math.random() * deckCarta.size());
        Carta temp = deckCarta.get(i);
        deckCarta.set(i, deckCarta.get(j));
        deckCarta.set(j, temp);
    }
}
```
**Embaralha** as cartas aleatoriamente.

**Toca** um som ao virar as cartas (menuSom.playSomVirarCartas()).


### Seleção de Cartas
Controla a lógica de virar cartas e verificar pares.

```java
botao.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        menuSom.playSomCarta();
        if (!jogoPronto) return;

        JButton botao = (JButton) e.getSource();
        if (botao.getIcon() == iconeTrasCarta) {
            if (selecionarCarta1 == null) {
                selecionarCarta1 = botao;
            } else if (selecionarCarta2 == null) {
                selecionarCarta2 = botao;

                if (selecionarCarta1.getIcon() != selecionarCarta2.getIcon()) {
                    menuSom.playSomErro();
                    contadorDeErros++;
                    atualizarTextoLabel();
                    esconderCartasGame.start();
                } else {
                    menuSom.playSomAcerto();
                    contadorAcertos++;
                    atualizarTextoLabel();
                    if (contadorAcertos == totalDePares) {
                        menuSom.playVitoria();
                        timer.stop();
                        JOptionPane.showMessageDialog(frame, "Parabéns! Você concluiu o jogo.", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
                        jogoPronto = true;
                        restartGameButton.setEnabled(true);
                    }
                }
            }
        }
    }
});

```
**Controla** a lógica de seleção de cartas.

**Se** duas cartas não forem iguais, esconde-as novamente após um tempo.

**Se** todas as cartas forem encontradas, exibe uma mensagem de vitória e para o timer.


### Controle do Timer
Mantém o tempo de jogo.

```java
timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        segundos++;
        atualizarTempoLabel();
    }
});
timer.setRepeats(true);
```
**Incrementa** o tempo a cada segundo.

**Atualiza** o rótulo tempoLabel.


### atualizarTempoLabel() (Atualizar o Rótulo de Tempo)
```java
void atualizarTempoLabel() {
        tempoLabel.setText("Tempo: " + segundos + "s");
    }
```
**Essa** função é chamada para atualizar o contador de tempo na interface gráfica.

**O tempo** é mostrado em segundos no formato "Tempo: XXs".

**Sempre** que o temporizador (timer) é disparado, ele chama essa função para incrementar o tempo (segundos++) e atualizar o rótulo na tela.

### atualizarTextoLabel() (Atualizar o Rótulo de Erros e Acertos)
```java
void atualizarTextoLabel() {
        textoLabel.setText("Erros: " + contadorDeErros + " | Acertos: " + contadorAcertos);
    }
```
**Essa** função é chamada para atualizar a quantidade de erros e acertos do jogador na interface gráfica.

**O** texto mostrado no rótulo é no formato "Erros: X | Acertos: Y", onde X é o número de erros e Y é o número de acertos.

**Ela** é chamada sempre que o jogador encontra um par de cartas, seja correto ou incorreto, para refletir a mudança na quantidade de acertos ou erros.

### esconderCartas (Timer de Esconder Cartas)
```java
 // Delay para o inicio do jogo e para o restart
        esconderCartas = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esconderCartasFunction();
            }
        });
        esconderCartas.setRepeats(false);//executa apenas uma vez e para até que seja chamada novamente
        esconderCartas.start();
```
**Este** timer é usado para esconder as cartas após um intervalo de tempo.

**É** configurado com um atraso de 5 segundos (5000 milissegundos) antes de chamar a função esconderCartasFunction().

**Ele** executa a função esconderCartasFunction() apenas uma vez, pois setRepeats(false) é chamado. Isso significa que o timer é executado apenas uma vez a cada vez que é iniciado.

**Quando** o timer é disparado, ele pode esconder todas as cartas no jogo ou, no contexto do reinício do jogo, exibir o verso de todas as cartas para começar o jogo.

### esconderCartasGame (Timer de Esconder Cartas Durante o Jogo)
```java
 // Delay para virar as cartas durante o jogo
        esconderCartasGame = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esconderCartasFunction();
            }
        });
        esconderCartasGame.setRepeats(false);//executa apenas uma vez e para até que seja chamada novamente
```
**Este** timer é similar ao esconderCartas, mas é usado enquanto o jogo está em andamento, especificamente quando duas cartas são viradas e não são iguais.

**Ele** tem um atraso de 1 segundo (1000 milissegundos) antes de chamar a função esconderCartasFunction().

**Como** o esconderCartas, ele é configurado para executar a função esconderCartasFunction() uma única vez.

### Esconder Cartas
Garante que cartas erradas sejam ocultadas novamente.

```java
void esconderCartasFunction() {
    if (jogoPronto && selecionarCarta1 != null && selecionarCarta2 != null) {
        selecionarCarta1.setIcon(iconeTrasCarta);
        selecionarCarta1 = null;
        selecionarCarta2.setIcon(iconeTrasCarta);
        selecionarCarta2 = null;
    } else {
        for (JButton botao : borda) {
            botao.setIcon(iconeTrasCarta);
        }
        jogoPronto = true;
        restartGameButton.setEnabled(true);
        timer.start();
    }
}
```
**Vira** todas as cartas no início.

**Esconde** cartas erradas durante o jogo.

**Inicia** o timer quando o jogo começa.

### restartGameButton (Botão de Reiniciar Jogo)
```java
 // Configuração do botão de reiniciar
        restartGameButton.setFont(new Font("Arial", Font.PLAIN, 20));
        restartGameButton.setFocusable(false);
        restartGameButton.setEnabled(false);
        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSom.playButtonSound2();
                menuSom.stopVitoria();
                menuSom.stopVitoriaNotBased();
                if (!jogoPronto) {
                    return;
                }
                // Para o timer antes de reiniciar o jogo
                timer.stop();
                segundos = 0;
                atualizarTempoLabel();

                jogoPronto = false;
                restartGameButton.setEnabled(false);
                selecionarCarta1 = null;
                selecionarCarta2 = null;

                // Mistura as cartas novamente
                misturarCarta();

                // Reseta o estado dos botões para mostrar o verso das cartas
                for (int i = 0; i < borda.size(); i++) {
                    borda.get(i).setIcon(deckCarta.get(i).iconeCarta);
                }

                // Reseta os contadores
                contadorDeErros = 0;
                contadorAcertos = 0;
                atualizarTextoLabel();

                // Reinicia o jogo e o timer
                esconderCartas.start();
            }
        });
```
**Esse** botão permite reiniciar o jogo.

**Quando** o botão é clicado:

**O** som de clique do botão é reproduzido com menuSom.playButtonSound2().

**A** música de vitória é interrompida e os sons de vitória são parados.

**O** temporizador (timer) é interrompido com timer.stop() e o contador de tempo é resetado (segundos = 0).

**As** variáveis de estado do jogo, como o contador de erros e acertos, são resetadas.

**O** baralho de cartas é embaralhado novamente com o método misturarCarta().

**As** cartas no tabuleiro são retornadas ao estado inicial (com o verso visível) através da configuração do ícone.

**O** botão de reiniciar é desabilitado até que o jogo termine novamente.

**O** jogo recomeça com a função esconderCartas.start().

### voltarButton (Botão de Voltar)
```java
 // Configuração do botão de voltar
        voltarButton.setFont(new Font("Arial", Font.PLAIN, 20));
        voltarButton.setFocusable(false);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSom.stopVitoria();
                menuSom.stopVitoriaNotBased();
                menuSom.playButtonSound2();
                frame.dispose(); // Fecha a janela atual
                new Jogo(); // Retorna para a classe Jogo
            }
        });
```
**Esse** botão permite que o jogador saia da tela atual e retorne para uma tela anterior.

**Ele** tem um ActionListener associado a ele, que reage quando o botão é pressionado.

**Quando** o botão é clicado:

**O** som de clique do botão é reproduzido através de menuSom.playButtonSound2().

**As** músicas de vitória são interrompidas usando menuSom.stopVitoria() e menuSom.stopVitoriaNotBased().

**A** janela atual é fechada com frame.dispose().

**Após** o fechamento, uma nova instância de Jogo é criada (provavelmente voltando para o menu ou tela principal do jogo).


## Conclusão
A classe `Gas` é um modelo para jogos da memória. O nome da classe pode mudar, assim como as cartas utilizadas, mas a estrutura permanece a mesma. O código gerencia a interface gráfica, lógica do jogo e controle do tempo, permitindo reutilização para diferentes conjuntos de cartas.

