# 🏆 Olimpíada de Questões - Refatoração SOLID
O objetivo deste foi refatorar uma aplicação Java com alto acoplamento para que ela obedecesse aos princípios SOLID.

## 🔄 Principais mudanças realizadas
Antes da refatoração
O projeto original concentrava toda a lógica em poucas classes, com:

Responsabilidades misturadas (leitura de entrada, regras de negócio e exibição na mesma classe);
Instâncias criadas diretamente com new dentro das classes que as utilizam;
Sem separação entre interface e implementação;

Depois da refatoração

- Cada funcionalidade foi extraída para sua própria classe (CadastrarParticipante, CadastrarProva, AplicarProva, etc.);
- As dependências passaram a ser injetadas via construtor, em vez de instanciadas internamente;
- Interfaces foram criadas para cada serviço no pacote repository;
- O menu foi transformado em uma estrutura dinâmica e extensível com OpcaoMenu;
- Outra alteração que merece destaque é que, as variáveis estáticas "proximaProvaId" e "proxiaQuestaoId", estavam inicialmente inicializadas com o valor 1. Isso gerava um erro, pois ao cadastrar uma nova prova ou questão,
teria o mesmo id da prova e questão já criadas através do método **seed**, na inicialização do sistema. Logo, foi necessário inicializá-las com o valor 2.


## 🧩 Princípios SOLID aplicados
### **S - Single Responsibility Principle (Responsabilidade Única)**
Cada classe possui uma única razão para mudar.

| Classe | Responsabilidade | 
|--------| -----------------|
| CadastrarParticipante | Cadastra participantes |
| CadastrarProva | Cadastra provas|
| CadastrarQuestao | Cadastra questões|
| AplicarProva | Coordena a aplicação de uma prova |
| CalcularNota | Apenas calcula a nota de uma tentativa |
| EscolherParticipante | Escolhe o participante para realizar a prova |
| EscolherProva | Escolhe a prova a ser aplicada |
| ImprimirTabuleiroFen | Apenas renderiza o tabuleiro de xadrez |
| ListarTentativas | Lista o resumo das tentativas dos usuários |
| OpcaoMenu | Classe modelo de uma opção do menu |
| Menu | Gerencia e exibe as opções do menu |
| Seed | Cria uma nova prova com uma questão |


### **O - Open/Closed Principle (Aberto/Fechado)**

"Aberto para extensão, fechado para modificação."

A classe **Menu** foi refatorada para receber opções dinamicamente via **OpcaoMenu**, sem precisar ser alterada quando uma nova funcionalidade é adicionada.

A classe **Menu** permanece fechada para modificação. Sua lógica de exibição nunca precisa mudar. A aplicação fica aberta para extensão, fazendo com que novas opções possam ser adicionadas usando o método **registrarNovaOpcao()**.


### **L - Liskov Substitution Principle (Substituição de Liskov)**
As interfaces do pacote repository declaram os métodos corretamente como abstratos (sem static e sem corpo), garantindo que qualquer implementação possa substituir a abstração sem quebrar o sistema.


### **I - Interface Segregation Principle (Segregação de Interfaces)**
Em vez de uma única interface genérica para todos os serviços, cada classe possui sua própria interface no pacote repository:

| repository |
| ---------- |
| AplicarProvaRepository |
| CadastrarParticipanteRepository |
| CadastrarProvaRepository |
| CadastrarQuestaoRepository |
| CalcularNotaRepository |
| EscolherParticipanteRepository |
| EscolherProvaRepository |
| ImprimirTabuleiroFenRepository |
| ListarTentativasRepository |
| MenuRepository |
| SeedRepository |


### **D - Dependency Inversion Principle (Inversão de Dependência)**
As dependências são injetadas via construtor, e as classes dependem de abstrações (interfaces), não de implementações concretas.

A montagem das dependências fica centralizada na classe **App**, que atua como ponto de composição da aplicação.

