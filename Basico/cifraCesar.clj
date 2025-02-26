(defn char->int [c]
  (int c))

(defn int->char [i]
  (char i))

(defn shift-char [c shift]
  (let [ascii (char->int c)
        base (if (Character/isUpperCase c) (char->int \A) (char->int \a))
        offset (mod shift 26)]
    (if (Character/isLetter c)
      (int->char (+ base (mod (- ascii base offset) 26)))
      c)))

(defn cifra-de-cesar [texto shift]
  (apply str (map #(shift-char % shift) texto)))

(def texto-original "HelloWorld")
(def deslocamento 3)
(def texto-cifrado (cifra-de-cesar texto-original deslocamento))

(println "Texto Original:" texto-original)
(println "Texto Cifrado:" texto-cifrado)