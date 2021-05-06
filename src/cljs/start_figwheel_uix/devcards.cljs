(ns start-figwheel-uix.devcards
  (:require [devcards.core :as dc]
            [start-figwheel-uix.core]))

(enable-console-print!)
(prn "Starting devcards...")
(dc/start-devcard-ui!)
