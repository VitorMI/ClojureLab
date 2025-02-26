(defn absolute-division [a b]
  (if (zero? b)
    "Divisão por zero não permitida"
    (Math/abs (/ a b))))

(defn process-input []
  (println "Quantidade de pares:")
  (let [n (Integer/parseInt (read-line))]
    (dotimes [_ n]
      (println "Primeiro número:")
      (let [a (Double/parseDouble (read-line))]
        (println "Segundo número:")
        (let [b (Double/parseDouble (read-line))]
          (println "Resultado: " (absolute-division a b)))))))

(process-input)