String getMiddle(String word){
    int len = word.length();
    if (len % 2 == 1){
      return Character.toString(word.charAt(len/2)); //  Most efficient way
    }else{
      return word.substring(len/2-1, len/2+1);        
}
