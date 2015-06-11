# FullAdder
Design Patterns 1
Door: Bryan Schreuder & Benny Bijl


Toegepaste designpatterns
De full adder kan aan elkaar geketend worden en wordt getest doormiddel van Junit. Binnen onze fulladder zijn de volgende designpatterns gebruikt:

Observer / Observable
De nodes zijn aan elkaar verbonden door middel van een Observer / Observable pattern, waarbij de nodes wachten tot ze het correcte aantal integers ontvangen hebben om hun rekenfunctie uit te voeren.
De nodes worden aan elkaar gekoppeld en wachten op input welke de voorgaande nodes versturen naar hun observers.

Low binding factory
De nodes worden geinitialiseerd in een low binding factory. De correcte nodes worden op basis van de input naam gekozen en geinitialiseerd door de factory, waardoor er geen enorme switch ontstaat.

Polymorfisme
De nodes maken gebruik van een abstracte node class en erven de gedeelde functies over van de parent. De verschillende nodes zijn het zelfde op de doCalc() functie na, welke de methode van de parent override. Daarnaast wordt bij de speciale endnodes (probes) de update functie vervangen om het eindresultaat van het circuit te tonen.



