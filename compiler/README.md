# Datalog Compiler

## Požiadavky

### 1. Java Development Kit (JDK) 21
`sudo apt-get install openjdk-21-jdk`

**Overenie**:
```bash
java -version
javac -version
```

### 2. Apache Maven
`sudo apt-get install maven`

**Overenie**:
```bash
mvn -version
```

## Build projektu

```bash
cd compiler
mvn clean compile
```

- Stiahne ANTLR runtime
- Vygeneruje parser a lexer zo súborov gramatiky
- Skompiluje všetky Java zdrojové súbory

## Spustenie kompilátora

```bash
mvn compile exec:java -Dexec.args="tests/000_turing_machine.dl"
```

## Štruktúra projektu
- `src/main/java/common/`: Spoločné triedy a rozhrania
- `src/main/java/datalog/`: Triedy reprezentujúce Datalog objekty
- `src/main/java/ra/`: Triedy reprezentujúce výrazy relačnej algebry
- `src/main/java/CompiledRAProgram.java`: Trieda reprezenetujúca skompilovaný program v relačnej algebre
- `src/main/java/DatalogASTBuilder.java`: Trieda pre vytváranie AST z parse stromu
- `src/main/java/DatalogCompiler.java`: Hlavná trieda pre kompiláciu Datalog programu do relačnej algebry
- `src/main/java/TranslateDatalogFile.java`: Trieda pre spustenie kompilátora na Datalog súbore (.dl)
