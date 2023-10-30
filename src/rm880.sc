;;; Sierra Script 1.0 - (do not remove this comment)
(script# 880)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use RandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm880 0
)

(local
	local0
	local1
)
(instance rm880 of LLRoom
	(properties
		lookStr {Studiov� patro budovy K-RAP je hluboko pod zem�, pln� zvukot�sn�ch studi� a reproduktor�. St�ed m�stnosti vypl�uje velk� font�na s ob��mi bronzov�mi sochami.}
		picture 880
		east 890
		west 870
	)
	
	(method (init)
		(proc958_0 128 872 880 882 883)
		(proc958_0 132 800 801 802)
		(gLarry
			init:
			normalize: 872
			actions: ActionsKRAP
			illegalBits: 2
		)
		(switch gGNumber
			(west (proc0_3) (= style 12))
			(east
				(gLarry posn: 250 127 setHeading: 270 edgeHit: 0)
			)
			(else 
				(proc0_3)
				(gLarry posn: 160 160 edgeHit: 0)
			)
		)
		(super init:)
		(doorA init: approachVerbs: 3 2)
		(doorB init: approachVerbs: 3 2)
		(doorC init: approachVerbs: 3 2)
		(windowA init:)
		(windowB init:)
		(windowC init:)
		(keypadA init: approachVerbs: 3 2)
		(keypadB init: approachVerbs: 3 2)
		(keypadC init: approachVerbs: 3 2)
		(PChammer init: setCycle: RandCycle cycleSpeed: 12)
		(movingSignA init: setCycle: Fwd cycleSpeed: 12)
		(gCast eachElementDo: #checkDetail)
		(mikeStand init:)
		(statue init:)
		(recSignA init:)
		(recSignB init:)
		(gAddToPics doit:)
		(self
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
						0
						189
						0
						133
						85
						138
						141
						148
						188
						166
						216
						187
						316
						187
						316
						171
						268
						132
						251
						120
						238
						116
						210
						116
						207
						124
						163
						124
						175
						109
						139
						76
						68
						76
						65
						72
						54
						82
						15
						116
						0
						116
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 91 109 97 105 120 105 124 112 117 120 97 120
					yourself:
				)
		)
		(gLl5MDHandler add: self)
		(gLl5KDHandler add: self)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_5 gLarry 2)
				(if local0
					(gLarry edgeHit: 1)
					(global2 newRoom: (global2 east?))
				else
					(proc0_14 880 0)
				)
			)
		)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(ActionsKRAP dispose:)
		(super dispose:)
	)
	
	(method (notify param1)
		(if
		(and (proc999_5 param1 global171 -2) (== local1 1))
			(doorB locked: 0)
			(= local1 0)
			(proc0_14 880 1)
		else
			(proc0_14 880 2)
		)
		(proc0_3)
	)
)

(instance doorA of Door
	(properties
		x 47
		y 77
		description {dve�e do ��dic� m�stnosti A}
		sightAngle 40
		approachX 64
		approachY 80
		lookStr {Tyto dve�e vedou do ��dic� m�stnosti A. Vid�te mu�e, kter� uvnit� pracuje.}
		view 880
		loop 1
		locked 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 880 3))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance doorB of Door
	(properties
		x 200
		y 111
		description {dve�e do ��dic� m�stnosti B}
		sightAngle 40
		approachX 218
		approachY 130
		lookStr {Tyto dve�e vedou do kontroln� m�stnosti B, kter� se zd� b�t pr�zdn�.}
		view 880
		loop 2
		entranceTo 890
		locked 1
		moveToX 220
		moveToY 116
		enterType 0
		exitType 0
	)
)

(instance doorC of Feature
	(properties
		x 265
		y 94
		nsTop 57
		nsLeft 257
		nsBottom 131
		nsRight 274
		description {dve�e do ��dic� m�stnosti C}
		sightAngle 40
		approachX 260
		approachY 100
		lookStr {Tyto dve�e vedou do kontroln� m�stnosti C. Zd� se, �e je moment�ln� pr�zdn�.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 880 3))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance keypadA of Feature
	(properties
		x 60
		y 39
		nsTop 31
		nsLeft 55
		nsBottom 47
		nsRight 65
		description {kl�vesnice}
		sightAngle 40
		approachX 64
		approachY 80
		lookStr {Ka�d� dve�e maj� kl�vesnici, kter� omezuje p��stup pouze osob�m s opr�vn�n�m. Tato kl�vesnice ovl�d� p��stup do ��dic� m�stnosti A.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				((ScriptID 20 0) init: 0 rm880)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance keypadB of Feature
	(properties
		x 239
		y 81
		nsTop 74
		nsLeft 232
		nsBottom 89
		nsRight 246
		description {kl�vesnice}
		sightAngle 40
		approachX 238
		approachY 115
		lookStr {Ka�d� dve�e maj� kl�vesnici pro omezen� p��stupu pouze osob�m s opr�vn�n�m. Tato kl�vesnice ovl�d� p��stup do ��dic� m�stnosti B.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(= local1 1)
				((ScriptID 20 0) init: 0 rm880)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance keypadC of Feature
	(properties
		x 254
		y 85
		nsTop 74
		nsLeft 248
		nsBottom 95
		nsRight 257
		description {kl�vesnice}
		sightAngle 40
		approachX 260
		approachY 100
		lookStr {Ka�d� dve�e maj� kl�vesnici pro omezen� p��stupu pouze osob�m s opr�vn�n�m. Tato kl�vesnice ovl�d� p��stup do ��dic� m�stnosti C.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				((ScriptID 20 0) init: 0 rm880)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance windowA of Feature
	(properties
		x 122
		y 41
		nsTop 29
		nsLeft 116
		nsBottom 53
		nsRight 128
		description {okno ��dic� m�stnosti A}
		sightAngle 40
		lookStr {P�es toto okno je vid�t do ��dic� m�stnosti A.}
	)
)

(instance windowB of Feature
	(properties
		x 161
		y 59
		nsTop 39
		nsLeft 146
		nsBottom 79
		nsRight 176
		description {okno ��dic� m�stnosti B}
		sightAngle 40
		lookStr {P�es toto okno vid�te ��dic� m�stnost B. Zd� se, �e v sou�asn� dob� nen� obsazena.}
	)
)

(instance windowC of Feature
	(properties
		x 303
		y 111
		nsTop 74
		nsLeft 287
		nsBottom 148
		nsRight 319
		description {okno ��dic� m�stnosti C}
		sightAngle 40
		lookStr {P�es toto okno vid�te ��dic� m�stnost C. Zd� se, �e je v sou�asn� dob� neobsazen�.}
	)
)

(instance statue of Feature
	(properties
		x 99
		y 106
		nsTop 24
		nsBottom 189
		nsRight 198
		description {socha}
		sightAngle 40
		onMeCheck $4000
		lookStr {Jak p�sobiv�! K-RAP m� font�nu s obrovskou sochou kr�lovny rock'n'rollu - Connie Stevensov�!}
	)
)

(instance recSignA of Feature
	(properties
		x 100
		y 26
		nsTop 24
		nsLeft 73
		nsBottom 29
		nsRight 128
		description {kontrolka nahr�v�n�}
		sightAngle 40
		lookStr {Tato kontrolka sv�t�, kdy� se v ��d�c� m�stnosti A nahr�v�.}
	)
)

(instance recSignB of Feature
	(properties
		x 162
		y 36
		nsTop 24
		nsLeft 144
		nsBottom 48
		nsRight 181
		description {kontrolka nahr�v�n�}
		sightAngle 40
		lookStr {Tato kontrolka sv�t�, kdy� se nahr�v� v ��dic� m�stnosti B.}
	)
)

(instance movingSignA of Prop
	(properties
		x 75
		y 28
		description {kontrolka nahr�v�n�}
		lookStr {V sou�asn� dob� sv�t� kontrolka nahr�v�n� v ��dic� m�stnosti A.}
		view 880
		loop 4
		priority 15
		signal $0010
	)
)

(instance PChammer of Actor
	(properties
		x 90
		y 67
		description {P. C. Hammer}
		view 883
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 880 4)
				(proc0_14 880 5)
			)
			(5 (proc0_14 880 6))
			(3 (proc0_14 880 7))
			(10
				(proc0_14 880 8)
				(proc0_14 880 9 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance mikeStand of PicView
	(properties
		x 175
		y 121
		description {stojan mikrofonu}
		view 880
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 880 10))
			(3
				(proc0_14 880 11)
				(proc0_14 880 12 67 -1 185)
			)
			(10
				(proc0_14 880 13)
				(proc0_14 880 14 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ActionsKRAP of Actions
	(properties)
	
	(method (doit)
		(return 0)
	)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(3 (proc0_14 880 15) (return 1))
				(10
					(proc0_14 880 16)
					(return 1)
				)
				(else  (return 0))
			)
		)
	)
)
