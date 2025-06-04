# Simulador de Sistema de Arquivos com Journaling em Java

## 📝 Resumo

Este trabalho propõe o desenvolvimento de um simulador para compreender o funcionamento de um sistema de arquivos com suporte a **journaling**, utilizando a linguagem de programação Java. O projeto visa facilitar a assimilação dos conceitos fundamentais de gerenciamento de arquivos dentro dos sistemas operacionais.

---

## 📌 Introdução

O gerenciamento eficiente de arquivos é crucial para o funcionamento dos sistemas operacionais. Para entender como um SO manipula dados em disco, é essencial compreender como um sistema de arquivos é montado, organizado e estruturado. Este projeto busca simular essas operações com suporte a **journaling**, garantindo a integridade das informações.

---

## 🎯 Objetivo

Desenvolver um simulador de sistema de arquivos em **Java** com as seguintes funcionalidades:

- Copiar arquivos
- Apagar arquivos
- Renomear arquivos
- Criar diretórios
- Apagar diretórios
- Renomear diretórios
- Listar arquivos de um diretório

Além disso, o sistema utilizará o conceito de **journaling** para garantir a integridade dos dados em caso de falhas.

---

## ⚙️ Metodologia

O simulador será desenvolvido utilizando a linguagem Java, com chamadas de métodos específicas para cada operação. Cada execução representa uma tarefa do sistema de arquivos, e os resultados serão exibidos no console. Em modo avançado, o sistema poderá ser executado como um shell, com comandos lidos de um arquivo que simula operações com suporte a journaling.

---

## 📚 Parte 1: Introdução ao Sistema de Arquivos com Journaling

### O que é um Sistema de Arquivos?

Um **sistema de arquivos** é responsável por organizar e armazenar dados em dispositivos de armazenamento, como HDs e SSDs. Ele fornece uma estrutura hierárquica (geralmente em árvore) para manipulação de arquivos e diretórios.

### Journaling

O **journaling** é uma técnica de registro de operações que garante a consistência dos dados mesmo após falhas inesperadas. Os principais tipos são:

- **Write-ahead logging (WAL)**: As operações são registradas antes de serem efetivamente aplicadas.
- **Log-structured file systems**: O sistema inteiro é baseado em logs sequenciais.
- **Metadata-only journaling**: Apenas alterações em metadados são registradas.

---

## 🧱 Parte 2: Arquitetura do Simulador

### Estrutura de Dados

As estruturas de dados utilizadas neste projeto foram definidas por meio de **classes Java orientadas a objetos**, formando uma estrutura hierárquica que simula um sistema de arquivos. As classes são:

- `FileSystemSimulator`: Classe principal do simulador. Controla a execução e interpreta os comandos do usuário.
- `Directory`: Representa um diretório, que contém uma lista de arquivos e outros diretórios. Utiliza internamente uma `List<File>` e `List<Directory>` para armazenar os elementos.
- `File`: Representa um arquivo simples, com nome e conteúdo.
- `Journal`: Gerencia o registro (log) das operações realizadas no sistema de arquivos, como criação, exclusão e renomeação. Utiliza uma `List<String>` como estrutura de log.

### Journaling

O **Journal** registrará operações como criação, remoção, renomeação e cópia de arquivos/diretórios. O log será armazenado em uma estrutura de dados interna e poderá ser salvo em disco (modo avançado).

---

## 💻 Parte 3: Implementação em Java

### Classes do projeto:

- **FileSystemSimulator**: Interface principal para execução das operações.
- **File**: Classe que representa um arquivo.
- **Directory**: Classe que representa um diretório.
- **Journal**: Classe que registra e gerencia as operações do sistema de arquivos.

---

## 🔧 Parte 4: Instalação e Funcionamento

### Requisitos

- Java JDK 11 ou superior

### Comandos

- **mkdir** nome - Cria um **diretório** chamado nome;
- **touch** nome - Cria um **arquivo** chamado nome;
- **rm** nome - Remove o **arquivo** chamado nome;
- **rmdir** nome - Remove o **diretório** chamado nome;
- **rename** antigo novo - **Renomeia** um arquivo ou diretório de antigo para novo;
- **cp** origem destino - **Copia** um arquivo da sua origem para o seu destino;
- **ls** - **Lista** arquivos e diretórios existentes;
- **exit** - **Encerra** o simulador e exibe o log de operações.

### Execução

1. Clone o repositório:
   ```
   git clone https://github.com/diegobenevidss/Simulador-de-Sistema-de-Arquivos.git
   ```   

2. Compile todos os arquivos java:
   ```
   cd src
   javac Diretory.java File.java FileSystemSimulator.java Journal.java
   ```

3. Execute a classe principal:
   ```
   java FileSystemSimulator
   ```
   
4. No console, digite os comandos desejados:
   ```
   Ex: 
   mkdir documentos
   touch agenda.txt
   ls
   rename agend.txt compromissos.txt
   rename agenda.txt compromissos.txt
   rm comprom.txt
   rm compromissos.txt
   rmdir doc
   rmdir documentos
   exit
   ```

5. Saída Esperada
   ```
   Logs de operações:
   Diretório criado: documentos
   Arquivo criado: agenda.txt
   Conteúdo do diretório raiz listado
   Falha ao renomear: agend.txt para compromissos.txt
   Renomeado: agenda.txt para compromissos.txt
   Falha ao remover arquivo: comprom.txt
   Arquivo removido: compromissos.txt
   Falha ao remover diretório: doc
   Diretório removido: documentos
   ```

---

## 👨‍💻 Autores
Desenvolvido por **Diego Benevides** e **Ian Sampaio**.

---

## 🔗 Repositório

[Acesse o repositório do projeto no GitHub.](https://github.com/diegobenevidss/Simulador-de-Sistema-de-Arquivos)