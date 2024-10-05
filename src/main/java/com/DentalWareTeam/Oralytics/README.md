<h1 align="center">Oralytics</h1>


![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)

## Integrantes do Grupo

Kayque Ferreira dos Santos - Desenvolvedor Backend

André Alves da Silva - Desenvolvedor Backend

Gabriel de Souza Grego - Desenvolvedor Frontend (não atuou nesse código)



## Descrição

O Oralytics é uma plataforma voltada para o monitoramento da saúde dentária dos usuários. Utilizamos inteligência artificial para ajudar os usuários a manterem uma rotina saudável de higiene bucal, identificando problemas dentários a partir de informações de monitoramento e oferecendo orientações baseadas no perfil de cada usuário.

## Público Alvo

A aplicação é voltada para:

- Pacientes odontológicos: usuários que desejam monitorar sua saúde bucal e receber orientações personalizadas.
- Clínicas odontológicas e profissionais da saúde bucal: dentistas e clínicas que desejam acompanhar o progresso de seus pacientes de forma mais eficiente.

## Problemas que a Aplicação se Propõe a Resolver

A aplicação visa resolver alguns dos principais problemas relacionados à saúde bucal:

- Monitoramento Inconsistente: Muitos usuários não sabem como monitorar corretamente a saúde de seus dentes. O Oralytics coleta dados, como frequência de escovação e problemas relatados, para fornecer feedback personalizado.
- Identificação Tardia de Problemas: Com o uso de IA e relatórios detalhados, a aplicação ajuda a detectar possíveis problemas dentários antes que se tornem mais graves.
- Falta de Personalização no Atendimento: Através do perfil do usuário, a aplicação gera orientações e relatórios personalizados com base nas necessidades individuais, promovendo um acompanhamento mais preciso.

## Instruções para Rodar a Aplicação

### Pré-requisitos

- Java 17+
- Oracle Database
- Gradle 7+
- Insomnia/Postman (para testar as APIs)
IDE (como IntelliJ ou Eclipse)

### Configuração

1. Clone o repositório:

```
git clone https://github.com/WedSan/Java-Challenge-FIAP.git
```

2. Navegue até o diretório do projeto:

```
cd oralytics
```

3. Configure as variáveis de ambiente no arquivo application.properties para a conexão com o banco de dados Oracle:

```
spring.application.name=Oralytics
spring.datasource.url= ${url_banco}
spring.datasource.username=${oracle_user)
spring.datasource.password=${oracle_password}
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```

4. Instale as dependências e compile o projeto com o Gradle:

```
./gradlew build
```

5. Execute a aplicação

```
./gradlew bootRun
```

6. Acesse sua ferramenta de teste para interagir com a API


## Diagramas

ATENÇÃO COLOCAR AQUI AS IMAGENS DOS DIAGRAMAS.

## Link de Apresentação da Proposta Tecnológica

ATENÇÃO COLOCAR AQUI O LINK DO VIDEO.

## Rotas de Endpoints

### AnaliseDentaria

- adicionarAnaliseDentaria = POST ("/AnaliseDentaria")
- listarAnalisesDentarias = GET ("/AnaliseDentaria")
- obterAnaliseDentaria = GET ("/AnaliseDentaria/{id}")

### DadosMonitoramento

- adicionarDadoMonitoramento = POST ("/DadosMonitoramento")
- listarDadosMonitoramento = GET ("/DadosMonitoramento")
- obterDadoMonitoramento = GET("/DadosMonitoramento/{id}")

### HistoricoDental

- adicionarHistoricoDental = POST ("/historicoDental")
- listarHistoricos = GET ("/historicoDental")
- obterHistoricoDental = GET ("/historicoDental/{id})

### Usuario

- adicionarUsuario = POST ("/usuarios")
- listarUsuarios = GET ("/usuarios")
- obterUsuario = GET ("/usuarios/{id}")
- atualizarEmail = GET ("/historicoDental/email/{id}")
- atualizarSenha = GET ("/historicoDental/senha/{id}")
 




