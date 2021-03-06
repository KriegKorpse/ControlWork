package com.KriegKorpse;

public class Alphabet {
   private static final char alphabet[] = { '\0', '\0',
           'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ь','Ы','Э','Ю','Я',
           'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ь','ы','э','ю','я',
           //'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
           //'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
           //'1','2','3','4','5','6','7','8','9','0',
           //'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~', ' '
           ' ', ','

  };

    int length(){
        return alphabet.length;
    }

   int indexOf(char c) {
      boolean found = false;
      int i = 2;
      while(!found && (i < alphabet.length))
         found = c == alphabet[i++];
      i--;
      if(!found)
         i = -1;
      return i;
   }

   char charOf(int i){
       return alphabet[i];
   }
   
   public boolean contain(char c) {
      return -1 != indexOf(c);
   }
   
}

