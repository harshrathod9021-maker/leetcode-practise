class Solution
{
    boolean isPalindrome(String s)
    {
        String s2 = new StringBuilder(s).reverse().toString();
        return s.equals(s2);
    }

    void getAllParts(String s, List<List<String>> ans, List<String> parts)
    {
        if (s.length() == 0)
        {
            ans.add(new ArrayList<>(parts));  // copy, since parts keeps changing
            return;
        }
        for (int i = 0; i < s.length(); i++)
        {
            String part = s.substring(0, i + 1);
            if (isPalindrome(part))
            {
                parts.add(part);
                getAllParts(s.substring(i + 1), ans, parts);
                parts.remove(parts.size() - 1);  // undo
            }
        }
    }

    public List<List<String>> partition(String s)
    {
        List<List<String>> ans = new ArrayList<>();
        List<String> parts = new ArrayList<>();
        getAllParts(s, ans, parts);
        return ans;
    }
}