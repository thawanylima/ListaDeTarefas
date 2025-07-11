# 📝 Lista de Tarefas - Java + SQLite

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![SQLite](https://img.shields.io/badge/SQLite-3.42.0-lightgrey)

Aplicativo de gerenciamento de tarefas com persistência em banco de dados SQLite, desenvolvido em Java no **NetBeans**.

Desenvolvido por: **Patrick Yokoyama Kloth e Thawany Souza Lima**

### 🚀 Funcionalidades
✅ Adicionar novas tarefas

🔄 Alterar status (concluído/pendente)

🔍 Filtrar tarefas por:

- Todas

- Pendentes

- Concluídas

💾 Persistência automática em banco de dados

## 📂 Estrutura do Projeto
<pre>
ListaDeTarefas/
├── lib/
│   └── sqlite-jdbc-3.50.2.0.jar   <i># Driver do SQLite</i>
├── src/
│   └── listadetarefas/
│       ├── Cod.java              <i># Lógica do banco de dados</i>
│       ├──ListaDeTarefas.java     <i># Classe principal</i>
│       └── Sql.java               <i># Conexão SQLite</i>
└── tarefas.db                     <i>#  Banco de dados</i>
</pre>



### 🔄Atualizando o SQLite JDBC

O projeto já inclui o driver na pasta lib/, mas se precisar atualizar:

Baixe a versão mais recente do [SQLite JDBC](https://github.com/xerial/sqlite-jdbc/releases)

Substitua o arquivo lib/sqlite-jdbc-3.50.2.0.jar


### 🛠️ Desenvolvimento
IDE: NetBeans 

Sistema de Build: Ant (via build.xml)

Persistência: SQLite com arquivo local (tarefas.db)

