# Domaの注釈処理をカスタマイズしたい

## 試し方

```console
# processorをビルドする
cd processor
gradlew build
# sampleをビルドする
cd ../sample
gradlew build
# 生成されたDaoImplを確認する
cat build/classes/main/sample/SampleDaoImpl.java
```

ファイルの先頭に"Hello, world!"とコメントが書き出されているはず。

## 仕組み

`processor`プロジェクトには`DaoProcessor`を継承した`CustomizedDaoProcessor`がある。
`javac`の`-processor`で`CustomizedDaoProcessor`を指定することで注釈処理をカスタマイズしている。

