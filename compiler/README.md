# Compiler

## Verzie
- Java 21.0.10
- ANTLR 4.9.2
- Maven 3.8.7

## Vygenerovanie ANTLR kódu
V priečinku `compiler/src/main/antlr4` spustite príkaz:

```bash
antlr4 datalog.g4 -visitor -package compiler -o .antlr
```

## Spustenie kompilátora
V priečinku `compiler` spustite príkaz:

```bash
mvn exec:java < tests/000_turing_machine.dl
```

`tests/000_turing_machine.dl` je ukážková cesta k súboru s Datalog programom, ktorý chcete spustiť.

## Vytvorenie .jar
V priečinku `compiler` spustite príkaz:

```bash
mvn package
```

Výsledný súbor `target/compiler.jar` obsahuje všetky závislosti.

## Spustenie .jar
```bash
java -jar target/compiler.jar < tests/000_turing_machine.dl
```


## Popis súborov
- `compiler/target/compiler.jar` - spustiteľný JAR vytvorený príkazom `mvn package`
- `compiler/src/main/antlr4/datalog.g4` - gramatika Datalogu
- `compiler/tests/` - vstupné Datalog programy (`.dl`) a očakávané výstupy (`.ra`)
- `compiler/generate_tests.sh` - skript, ktorý pre každý datalogový program v `compiler/tests/` vygeneruje očakávaný výstup v relačnej algebre pomocou kompilátora
- `compiler/src/main/java/` - zdrojové kódy kompilátora
    - `common/` - spoločné triedy pre Datalog a relačnú algebru
        - `Constant.java`
        - `FunctionTerm.java`
        - `Parameter.java`
        - `Term.java` - abstraktná trieda pre všetky termy (konštanty, funkčné termy, atď.)
        - `Variable.java`
    - `datalog/` - triedy špecifické pre Datalog
        - `Atom.java`
        - `Clause.java`
        - `DatalogProgram.java` - reprezentácia Datalog programu ako celku
        - `Definition.java`
        - `Predicate.java`
        - `Query.java`
    - `ra/` - triedy špecifické pre relačnú algebru
        - `RAAntiJoin.java`
        - `RADef.java` - reprezentácia definície v relačnej algebre, ktorá sa následne pretransformuje na niekoľko `RAJoin`-ov
        - `RAExpr.java` - abstraktná trieda pre všetky výrazy v relačnej algebre
        - `RAJoin.java`
        - `RARec.java`
        - `RAUnion.java`
        - `RelationRef.java` - odkaz na reláciu
    - `DatalogASTBuilder.java` - návštevník pre vytváranie AST z ANTLR parse stromu
    - `DatalogCompiler.java` - hlavná trieda kompilátora zodpovedná za
      preklad z Datalog AST do relačnej algebry
    - `MyErrorListener.java` - príprava pre potenciálne vlastné spracovanie
      chýb počas lexingu/parsing-u
    - `TranslateDatalogFile.java` - trieda s `main` metódou, ktorá načíta Datalog program zo štandardného vstupu, preloží ho a vypíše výslednú relačnú algebru na štandardný výstup