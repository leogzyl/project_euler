(ns euler.problem16
   (:require [clojure.string :as str]))

; Power digit sum
; Problem 16

; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

; What is the sum of the digits of the number 2^1000?

(defn bigexp [num exponent]
  (if (= exponent 1)
    num
    (* (bigint num) (bigexp num (dec exponent)))))

(def problem16 
  (->> 
    (-> 
      (bigexp 2 1000)
      str 
      (clojure.string/split #"")) 
    (map #(Integer/parseInt %)) 
    (reduce +)))
