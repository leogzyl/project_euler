(ns euler.problem16
  (:use [euler.problem15])
  (:require [clojure.string :as str]))

; Power digit sum
; Problem 16

; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

; What is the sum of the digits of the number 2^1000?

(def problem16 
  (->> 
    (-> 
      (bigexp 2 1000)
      str 
      (clojure.string/split #"")) 
    (map #(Integer/parseInt %)) 
    (reduce +)))
