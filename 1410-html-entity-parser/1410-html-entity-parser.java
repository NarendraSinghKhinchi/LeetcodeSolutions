class Solution {
    public String entityParser(String text) {
        
        HashMap<String , String> hm = new HashMap<>();
        hm.put("&quot;" , "\"");
        hm.put("&apos;" , "'");
        // hm.put("&amp;" , "&");
        hm.put("&gt;" , ">");
        hm.put("&lt;" , "<");
        hm.put("&frasl;" , "/");
        
        
        for (String key : hm.keySet()) {
            text = text.replaceAll(key, hm.get(key));
        }
        
        return text.replaceAll("&amp;", "&");  
        
    }
}