;;; Sierra Script 1.0 - (do not remove this comment)
(script# 820)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Polygon)
(use CueObj)
(use n958)
(use Obj)

(public
	rm820 0
)

(local
	local0
)
(instance rm820 of LLRoom
	(properties
		lookStr {"Tento vestibul je docela pùsobivı," pomyslíš si, "obzvláš na tak malou budovu."}
		picture 820
		south 800
		west 840
	)
	
	(method (init)
		(proc958_0 128 820)
		(proc958_0 132 800 801 802)
		(proc0_3)
		(gLarry init: x: 280 normalize:)
		(gLongSong setVol: (* (/ (gLongSong vol?) 3) 2))
		(keypad init: approachVerbs: 3 2)
		(door init:)
		(krapWindow init:)
		(plant init:)
		(outerdesk init:)
		(tree init:)
		(backcounter init:)
		(forecounter init:)
		(lamp init:)
		(lights init:)
		(chair init: approachVerbs: 2 3)
		(super init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						315
						189
						315
						130
						280
						129
						255
						129
						187
						128
						184
						119
						306
						119
						306
						117
						80
						117
						73
						121
						71
						120
						49
						142
						56
						145
						8
						145
						8
						156
						49
						156
						2
						175
						2
						187
						185
						186
						221
						172
						269
						182
						268
						189
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 62 154 67 143 67 137 116 137 135 125 172 125 169 140 160 150 107 154
					yourself:
				)
		)
		(gLarry observeControl: 2)
		(gLl5MDHandler add: self)
		(gLl5KDHandler add: self)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(super dispose:)
	)
	
	(method (notify param1)
		(if (proc999_5 param1 -19582 -2)
			(door locked: 0)
			(proc0_14 820 0)
		else
			(proc0_14 820 1)
		)
		(proc0_3)
	)
)

(instance door of Door
	(properties
		x 18
		y 154
		description {dveøe}
		approachX 58
		approachY 152
		view 820
		entranceTo 840
		locked 1
		moveToX 20
		moveToY 146
		enterType 0
		exitType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (not (self locked?))
					(proc0_14 820 2)
					(gLarry ignoreControl: 2)
				)
				(super doVerb: theVerb param2 &rest)
			)
			(2
				(proc0_14 820 3)
				(proc0_14 820 4 30 1)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance krapWindow of Feature
	(properties
		x 197
		y 73
		nsTop 43
		nsLeft 75
		nsBottom 102
		nsRight 315
		description {okno z tabulového skla}
		sightAngle 0
		lookStr {Pøes okno vidíte noèní panorama krásného centra Filadelfie.}
	)
)

(instance outerdesk of Feature
	(properties
		x 114
		y 130
		nsTop 119
		nsLeft 78
		nsBottom 142
		nsRight 150
		description {stùl recepèní}
		sightAngle 40
		lookStr {Toto je stùl recepèní. Naštìstí pro tebe se zdá, e právì teï není pøítomna.}
	)
)

(instance plant of Feature
	(properties
		x 221
		y 167
		nsTop 157
		nsLeft 203
		nsBottom 178
		nsRight 240
		description {kvìtina}
		sightAngle 40
		lookStr {Kvìtina v kvìtináèi velmi pøispívá k atmosféøe v kanceláøi.}
	)
)

(instance keypad of Feature
	(properties
		x 51
		y 108
		nsTop 101
		nsLeft 46
		nsBottom 115
		nsRight 57
		description {klávesnice}
		sightAngle 40
		approachX 58
		approachY 142
		lookStr {Tato klávesnice ovládá pøístup ke dveøím do soukromé kanceláøe Johna Krappera.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				((ScriptID 20 0) init: 0 rm820)
			)
			(3
				((ScriptID 20 0) init: 0 rm820)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 268
		y 74
		nsTop 41
		nsLeft 248
		nsBottom 108
		nsRight 289
		description {strom v kvìtináèi}
		sightAngle 40
		lookStr {Tady musí bıt pøes den více svìtla.}
	)
)

(instance forecounter of Feature
	(properties
		x 200
		y 182
		nsTop 176
		nsLeft 156
		nsBottom 189
		nsRight 245
		description {kvìtináè}
		sightAngle 40
		lookStr {Tento kvìtináè je poblí vchodovıch dveøí.}
	)
)

(instance backcounter of Feature
	(properties
		x 254
		y 115
		nsTop 107
		nsLeft 189
		nsBottom 124
		nsRight 319
		description {zadní pult}
		sightAngle 40
		lookStr {Tento pult vypadá skoro jako sedátko u okna.}
	)
)

(instance lamp of Feature
	(properties
		x 142
		y 110
		nsTop 103
		nsLeft 127
		nsBottom 118
		nsRight 158
		description {lampa}
		sightAngle 40
		lookStr {Tato lampa se ti opravdu líbí.}
	)
)

(instance lights of Feature
	(properties
		x 87
		y 20
		nsTop 1
		nsLeft 54
		nsBottom 39
		nsRight 121
		description {svìtla}
		sightAngle 40
		lookStr {Subtilní svìtla nástìnnıch podloek vrhají krásnou záøi na supergrafiku na stìnì vestibulu.}
	)
)

(instance chair of Feature
	(properties
		x 104
		y 124
		heading 180
		nsTop 106
		nsLeft 97
		nsBottom 124
		nsRight 111
		description {køeslo}
		sightAngle 40
		approachX 104
		approachY 120
		lookStr {Køeslo recepèní je prázdné, ale stále teplé na dotek. Je pryè jen krátce a moná se brzy vrátí.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 lookStr))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)
