;;; Sierra Script 1.0 - (do not remove this comment)
(script# 870)
(include sci.sh)
(use Main)
(use LLRoom)
(use RandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm870 0
)

(instance rm870 of LLRoom
	(properties
		lookStr {Studiové patro budovy K-RAP je hluboko pod zemí, plné zvukotìsných studií a reproduktorù. Støed místnosti vyplòuje velká fontána s obøími bronzovými sochami.}
		picture 870
		east 880
	)
	
	(method (init)
		(proc958_0 128 870 871 872 873)
		(proc958_0 132 853 800 801 802)
		(switch gGNumber
			(east
				(proc0_3)
				(= style 11)
				(gLarry
					init:
					actions: ActionsKRAP
					edgeHit: 4
					normalize: 872
				)
				(elevator init: setPri: -1 addToPic:)
				(eDoor init: setPri: -1 addToPic:)
				(elevatorSide init: setPri: -1 addToPic:)
				(gAddToPics doit:)
				(door init: approachVerbs: 3)
				(keypad init: approachVerbs: 3 2)
				(studioARoom init:)
				(studioBRoom init:)
				(studioCRoom init:)
				(elevatorKeypad init: approachVerbs: 3 2)
			)
			(else 
				(proc0_3)
				(proc0_13 0)
				(gLarry init: normalize: 873 hide:)
				(door init:)
				(keypad init:)
				(studioARoom init:)
				(studioBRoom init:)
				(studioCRoom init:)
				(elevatorKeypad init:)
				(self setScript: goingDownScript)
			)
		)
		(statue init:)
		(dude1 init: setCycle: RandCycle)
		(dude2 init: setCycle: RandCycle)
		(dude3 init: setCycle: RandCycle)
		(super init:)
		(clothesRack init:)
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
						100
						293
						100
						261
						63
						201
						63
						173
						100
						124
						101
						104
						134
						92
						133
						76
						134
						64
						134
						54
						146
						90
						146
						73
						168
						44
						179
						24
						174
						11
						187
						135
						187
						151
						176
						186
						162
						235
						153
						319
						153
						319
						189
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 197 116 204 110 228 110 233 115 225 122 204 122
					yourself:
				)
		)
		(gLl5MDHandler add: self)
		(gLl5KDHandler add: self)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(ActionsKRAP dispose:)
		(super dispose:)
	)
	
	(method (notify)
		(proc0_14 870 0)
		(proc0_3)
	)
)

(instance clothesRack of PicView
	(properties
		x 68
		y 158
		description {vìšák na šaty}
		lookStr {To je úleva! Hned vedle výtahu stojí vìšák s obleèením.}
		view 870
		cel 3
		signal $4000
	)
)

(instance keypad of Feature
	(properties
		x 231
		y 35
		nsTop 29
		nsLeft 227
		nsBottom 41
		nsRight 235
		description {klávesnice}
		sightAngle 40
		lookStr {Tato klávesnice je podobná tìm nahoøe. Bohužel k ní neznáš kombinaci.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (!= (gLarry view?) 873)
					((ScriptID 20 0) init: 0 rm870)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance studioARoom of Feature
	(properties
		x 180
		y 46
		nsTop 28
		nsLeft 171
		nsBottom 64
		nsRight 190
		description {Studio A}
		sightAngle 40
	)
	
	(method (doVerb)
		(dude1 doVerb: &rest)
	)
)

(instance door of Feature
	(properties
		x 245
		y 42
		nsTop 24
		nsLeft 235
		nsBottom 60
		nsRight 255
		description {dveøe do studia}
		sightAngle 40
		lookStr {Tyto dveøe vedou do studia B spoleènosti K-RAP.}
	)
)

(instance studioBRoom of Feature
	(properties
		x 203
		y 37
		nsTop 24
		nsLeft 198
		nsBottom 51
		nsRight 208
		description {Studio B}
		sightAngle 40
		lookStr {Tyto jsou dveøe do studia B spoleènosti K-RAP.}
	)
)

(instance studioCRoom of Feature
	(properties
		x 278
		y 42
		nsTop 23
		nsLeft 268
		nsBottom 62
		nsRight 288
		description {Studio C}
		sightAngle 40
		lookStr {Toto je studio C spoleènosti K-RAP.}
	)
)

(instance statue of Feature
	(properties
		x 217
		y 1
		nsTop 20
		nsLeft 116
		nsBottom 189
		nsRight 319
		description {socha}
		sightAngle 40
		onMeCheck $4000
		lookStr {Jak pùsobivé! K-RAP má fontánu s obrovskou sochou krále rock'n'rollu - Barryho Manilowa!}
	)
)

(instance elevatorKeypad of Feature
	(properties
		x 9
		y 157
		nsTop 138
		nsLeft 4
		nsBottom 157
		nsRight 15
		description {klávesnice od výtahu}
		sightAngle 40
		approachX 20
		approachY 180
		lookStr {Tato klávesnice je podobná tìm nahoøe. Bohužel k ní neznáš kombinaci.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 870 1))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance clothes of View
	(properties
		x 68
		y 179
		z 20
		description {obleèení}
		sightAngle 40
		approachX 56
		approachY 162
		lookStr {Na vìšáku na obleèení, pøíhodnì umístìném poblíž výtahu, visí sada pestrobarevných, nadmìrnì velkých rapperských šatù.}
		view 870
		cel 2
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (== (gLarry view?) 873)
					(gLarry setScript: getClothesScript)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance dude1 of Prop
	(properties
		x 142
		y 71
		description {ten "2 Live 2 Screw" týpek}
		view 870
		loop 2
		cycleSpeed 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 870 2))
			(3 (proc0_14 870 3))
			(10 (proc0_14 870 4))
			(4 (proc0_14 870 5))
			(else  (proc0_14 870 6))
		)
	)
)

(instance dude2 of Prop
	(properties
		x 134
		y 68
		description {ten "2 Live 2 Screw" týpek}
		view 870
		loop 3
		cycleSpeed 10
	)
	
	(method (doVerb theVerb param2)
		(dude1 doVerb: theVerb param2)
	)
)

(instance dude3 of Prop
	(properties
		x 150
		y 63
		description {ten "2 Live 2 Screw" týpek}
		view 870
		loop 4
		cycleSpeed 8
	)
	
	(method (doVerb theVerb param2)
		(dude1 doVerb: theVerb param2)
	)
)

(instance elevator of View
	(properties
		x 44
		y 171
		description {sprchovýtah}
		view 870
		priority 8
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 870 7))
			(3 (proc0_14 870 8))
			(10 (proc0_14 870 9))
			(4 (proc0_14 870 10))
			(else  (proc0_14 870 11))
		)
	)
)

(instance eDoor of Prop
	(properties
		x 44
		y 171
		description {sprchovýtah}
		view 870
		loop 1
		priority 15
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(elevator doVerb: theVerb param2)
	)
)

(instance elevatorSide of View
	(properties
		x 44
		y 171
		description {sprchovýtah}
		view 870
		cel 1
		priority 15
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(elevator doVerb: theVerb param2)
	)
)

(instance elevatorWithPatti of Actor
	(properties
		x 44
		y 5
		description {tvé nahé tìlo}
		lookStr {Jak hluboko jsi klesla!}
		view 870
		loop 5
		signal $4000
	)
)

(instance goingDownScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong setVol: gGLongSongVol)
				(clothes init: setPri: 12)
				(elevatorWithPatti
					init:
					setLoop: 5
					setCel: 0
					moveSpeed: 3
					setMotion: MoveTo 44 171 self
				)
			)
			(1
				(gLongSong2 release:)
				(= ticks 30)
			)
			(2
				(elevatorWithPatti dispose:)
				(elevator init: setPri: 12 stopUpd:)
				(eDoor init: setPri: -1 stopUpd:)
				(elevatorSide init: setPri: -1 stopUpd:)
				(gLarry
					show:
					x: 37
					y: 183
					z: 20
					setLoop: 4
					setCel: 0
					setPri: 12
					actions: ActionsKRAP
				)
				(proc0_3)
				(gIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance getClothesScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(eDoor startUpd: setCel: 0)
				(= seconds 3)
			)
			(1
				(proc0_14 870 12)
				(= seconds 3)
			)
			(2 (eDoor setCycle: End self))
			(3
				(gLarry
					x: 43
					y: 166
					z: 0
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 56 162 self
				)
			)
			(4
				(proc0_10 1 153)
				(clothes hide:)
				(gLarry
					view: 871
					setLoop: 0
					setCel: 0
					x: 69
					y: 160
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(5
				(gLarry
					normalize: 872
					x: 56
					y: 162
					loop: 0
					setMotion: MoveTo 78 166 self
				)
			)
			(6
				(proc0_14 870 13)
				(proc0_14 870 14)
				(eDoor setCycle: Beg self)
			)
			(7
				(eDoor setPri: -1 stopUpd:)
				(gIconBar enable: 0)
				(door approachVerbs: 3)
				(keypad approachVerbs: 3 2)
				(elevatorKeypad approachVerbs: 3 2)
				(proc0_3)
				(self dispose:)
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
				(3
					(if (== (gLarry view?) 873)
						(proc0_14 870 15)
						(return 1)
					else
						(proc0_14 870 16)
						(return 1)
					)
				)
				(10
					(if (== (gLarry view?) 873)
						(proc0_14 870 15)
						(return 1)
					else
						(proc0_14 870 17)
						(return 1)
					)
				)
				(else  (return 0))
			)
		)
	)
)
