import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;                        // ディレクトリの名前
    private ArrayList dir = new ArrayList();    // ディレクトリエントリの集合
    public Directory(String name) {             // コンストラクタ
        this.name = name;
    }
    @Override
    public String getName() {                   // 名前を得る
        return name;
    }
    public int getSize() {                       // サイズを得る
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            size += entry.getSize();
        }
        return size;
    }
    @Override
    public Entry add(Entry entry) {             // エントリの追加
        dir.add(entry);
        return this;
    }
    @Override
    public Iterator iterator() {                // Iteratorの生成
        return dir.iterator();
    }
    public void accept(Visitor v) {             // 訪問者の受入
        v.visit(this);
    }
}