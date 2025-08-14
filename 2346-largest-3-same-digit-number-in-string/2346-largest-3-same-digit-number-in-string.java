class Solution {
    public String largestGoodInteger(String num) {
        ArrayList<String> list= new ArrayList<>();
        for(int i=0;i<num.length()-2;i++)
        {
          String val = num.substring(i, i + 3);
          if (val.charAt(0) == val.charAt(1) && val.charAt(1) == val.charAt(2)) {
                list.add(val);
            }
        }

         if (list.isEmpty()) return "";

        Collections.sort(list);

        return list.get(list.size()-1);
    }
}