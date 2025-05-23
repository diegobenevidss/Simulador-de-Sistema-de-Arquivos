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

- `FileSystemSimulator`: Classe principal do simulador.
- `File`: Representa um arquivo com nome e conteúdo.
- `Directory`: Representa um diretório, contendo arquivos e outros diretórios.
- `Journal`: Gerencia o log de operações para garantir a integridade.

### Journaling

O **Journal** registrará operações como criação, remoção, renomeação e cópia de arquivos/diretórios. O log será armazenado em uma estrutura de dados interna e poderá ser salvo em disco (modo avançado).

---

## 💻 Parte 3: Implementação em Java

### Principais Classes:

- **FileSystemSimulator**: Interface principal para execução das operações.
- **File**: Classe que representa um arquivo.
- **Directory**: Classe que representa um diretório.
- **Journal**: Classe que registra e gerencia as operações do sistema de arquivos.

---

## 🔧 Parte 4: Instalação e Funcionamento

### Requisitos

- Java JDK 11 ou superior
- IDE como Eclipse, IntelliJ ou VS Code

### Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/NOME_DO_PROJETO.git
