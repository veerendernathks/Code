package Trie;

public class Trie
{
    static class Node
    {
        Node[] children;
        boolean eow;

        Node()
        {
            children = new Node[26];
            for (int i=0; i<26; i++)
            {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word)
    {
        Node current = root;
        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i)-'a';
            if(current.children[idx]==null)
            {
                current.children[idx] = new Node();
            }
            if (i == word.length()-1)
            {
                current.children[idx].eow = true;
            }
            current = current.children[idx];
        }
    }

    public static boolean search(String word)
    {
        Node current = root;
        for(int i=0; i<word.length(); i++)
        {
            int idx = word.charAt(i)-'a';
            if(current.children[idx] == null)
            {
                return false;
            }
            if(i == word.length()-1 && current.children[idx].eow != true)
            {
                return false;
            }
            current = current.children[idx];
        }
        return true;
    }

    public static boolean wordBreak(String key)
    {
        if (key.length()==0)
        {
            return true;
        }
        for (int i=1; i<=key.length(); i++)
        {
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);
            if (search(firstPart) && wordBreak(secondPart))
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
//        String words[] = {"the", "a", "there", "their", "any"};

//        String words[] = {"i", "like", "sam", "samsung", "mobile"};
//        for (int i=0; i<words.length; i++)
//        {
//            insert(words[i]);
//        }
//        System.out.println(search("i"));
//        System.out.println(search("like"));
//        System.out.println(search("veer"));

        String words[] = {"i", "like", "sam", "samsung", "mobile"};
        String key = "ilikesamsung";
        for (int i=0; i<words.length; i++)
        {
            insert(words[i]);
        }
        System.out.println(wordBreak(key));

    }
}
