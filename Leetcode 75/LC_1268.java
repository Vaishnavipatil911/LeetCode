import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_1268 {
    class Solution {
    class TrieNode{
        TrieNode[] children =new TrieNode[26];
        List<String>suggestions=new ArrayList<>();
    }
    TrieNode root=new TrieNode();
    private void insert(String word)
    {
        TrieNode node=root;
        for(char ch: word.toCharArray())
        {
            int index=ch-'a';
            if(node.children[index]==null)
            {
                node.children[index]=new TrieNode();
            }
            node=node.children[index];
            if(node.suggestions.size()<3)
            {
                node.suggestions.add(word);
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for(String product:products)
        {
            insert(product);
        }
        List<List<String>> result=new ArrayList<>();
        TrieNode node=root;
        for(char ch: searchWord.toCharArray())
        {
            int index=ch-'a';
            if(node!=null && node.children[index]!=null)
            {
                node=node.children[index];
                result.add(node.suggestions);

            }
            else
            {
                node=null;
                result.add(new ArrayList<>());
            }
        }
        return result;
    }
}
}
