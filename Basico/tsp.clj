;; Problema do Caixeiro Viajante
(ns tsp)

;; Calcula a distância euclidiana entre duas cidades representadas por coordenadas (x, y).
;; Formula: sqrt((x2 - x1)^2 (y2 - y1)^2)
(defn distancia [[x1 y1] [x2 y2]]
  (Math/sqrt
   (+ (Math/pow (- x2 x1) 2)
      (Math/pow (- y2 y1) 2))))

;; Calcula o custo total de uma rota, que é a soma das distâncias entre cidades consecutivas.
;; A rota é circular, ou seja, a última cidade se conecta de volta à primeira.
(defn custoRota [cidades]
  (reduce + (map distancia cidades (concat (rest cidades) [(first cidades)]))))

;; Gera todas as permutações possíveis de uma lista de elementos.
;; Isso é útil para explorar todas as possíveis rotas no problema do TSP.
(defn permutacao [coll]
  (if (empty? coll)
    [[]]
    (for [x coll
          xs (permutacao (remove #{x} coll))]
      (cons x xs))))

;; Resolve o problema do TSP (Caixeiro Viajante) usando força bruta.
;; Gera todas as permutações possíveis de rotas e calcula o custo de cada uma.
;; Retorna a rota com o menor custo e seu respectivo custo.
(defn forcaBruta [cidades]
  (let [todasPermutacoes (permutacao cidades)
        costs (map #(vector % (custoRota %)) todasPermutacoes)]
    (first (sort-by second costs))))

;; Função principal para testar o algoritmo do TSP.
;; Define uma lista de cidades com suas coordenadas, calcula a melhor rota e imprime o resultado.
(defn -main []
  (let [cities [[0 0] [3 4] [7 3] [6 0] [2 2]]] ;; Lista de cidades com coordenadas (x, y)
    (println "Cidades:" cities)
    (let [[melhorRota melhorCusto] (forcaBruta cities)
          formatted-cost (format "%.2f" melhorCusto)] ;; Formata o custo com duas casas decimais
      (println "Melhor rota:" melhorRota)
      (println "Custo mínimo:" formatted-cost))))

(-main)
