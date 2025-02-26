(ns mdc 
  (:require [clojure.string :as str]))

(defn mdc [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn trocas-figurinhas []
  (println "Digite o número de pares:")
  (let [n (Integer/parseInt (read-line))]
    (doseq [i (range n)]
      (println (str "Digite os pares (separados por espaço)" (inc i) ":"))
      (let [input (read-line)
            [a b] (map #(Integer/parseInt %) (str/split input #"\s+"))]
        (println (str "O maior bolo de figurinhas possível para troca é: " (mdc a b)))))))

(trocas-figurinhas)
