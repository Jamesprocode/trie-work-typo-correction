public class TrieTester {
    public static void main(String[] args) {
        TrieTree test = new TrieTree();
        test.insert("is");
        test.insert("there");
        test.insert("something");
        test.insert("left");
        test.insert("to");
        test.insert("luvv");
        test.insert("aardvark");
        test.insert("aardvarks");
        test.insert("hellos");
        test.insert("hello");
        test.insert("hells");

        System.out.println(test.search("luvv"));
        test.remove("luvv");
        System.out.println(test.search("luvv"));

        System.out.println(test.wordListForPrefix("he"));

    }
}
