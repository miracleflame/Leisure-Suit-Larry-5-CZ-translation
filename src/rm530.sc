;;; Sierra Script 1.0 - (do not remove this comment)
(script# 530)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm530 0
)

(local
	local0
	local1
	local2
	local3
	local4
)
(instance rm530 of LLRoom
	(properties
		lookStr {Teï už chápeš, proè je to tak exkluzivní pokoj. Je tu klid, krása a soukromí.}
		picture 530
		south 525
	)
	
	(method (init)
		(proc958_0 128 531 1530)
		(super init:)
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
						239
						189
						255
						148
						208
						123
						183
						120
						166
						106
						92
						106
						53
						138
						55
						159
						128
						170
						129
						189
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 175 141 203 137 226 141 249 154 236 163 220 166
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 202 160 187 168 161 163 150 153 187 153
					yourself:
				)
		)
		(drape1 init: stopUpd:)
		(drape2 init: stopUpd:)
		(drape3 init: stopUpd:)
		(cactus init:)
		(cart init:)
		(light init:)
		(theTable init:)
		(chair init:)
		(iceCream init:)
		(if (!= gGNumber 535)
			(table1 init:)
			(table2 init:)
			(table3 init:)
			(extra1 init:)
			(extra2 init:)
			(extra3 init:)
			(extra4 init:)
			(extra5 init:)
			(gLarry init: normalize: posn: 151 234 edgeHit: 0)
			(michelle init: setScript: sMichelleEating)
			(drape4 init: stopUpd:)
			(self setScript: sEnter)
		else
			(michelle init:)
			(gLarry
				init:
				view: 531
				setLoop: 1
				posn: 260 143
				setCel: 255
				setCycle: 0
			)
			(if (not (proc0_6 16))
				(proc0_7 16)
				(drape4 init: setCel: 0 stopUpd:)
				(self setScript: sCloseCurtain)
			else
				(drape4 init: setCel: 255 stopUpd:)
				(self setScript: sOpenCurtain)
			)
		)
		(gAddToPics doit:)
		(if (!= (gLongSong number?) 535)
			(gLongSong number: 535 setLoop: -1 flags: 1 play:)
		)
	)
)

(instance sTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(proc0_18 Michelle_Milken 530 0 108 139 self)
					)
					(1
						(proc0_18 Michelle_Milken 530 1 108 139 self)
					)
					(2
						(proc0_18 Michelle_Milken 530 2 108 139 self)
					)
				)
			)
			(1
				(switch register
					(0
						(proc0_14 530 3 67 -1 185)
						(self dispose:)
					)
					(1
						(proc0_14 530 4 67 -1 185)
						(self dispose:)
					)
					(2
						(proc0_14 530 5 67 -1 185)
						(global2 setScript: sDoMichelle)
					)
				)
			)
		)
	)
)

(instance iceCream of PicView
	(properties
		x 244
		y 109
		description {její zmrzlina}
		sightAngle 90
		view 530
		loop 6
		cel 5
		signal $1800
	)
)

(instance extra1 of PicView
	(properties
		x 63
		y 89
		description {pár}
		sightAngle 90
		view 530
		loop 6
		cel 1
		priority 5
		signal $1810
	)
)

(instance extra2 of PicView
	(properties
		x 80
		y 88
		description {pár}
		sightAngle 90
		view 530
		loop 6
		cel 2
		priority 5
		signal $1810
	)
)

(instance extra3 of PicView
	(properties
		x 184
		y 88
		description {pár}
		sightAngle 90
		view 530
		loop 6
		priority 4
		signal $1810
	)
)

(instance extra4 of PicView
	(properties
		x 119
		y 78
		description {pár}
		sightAngle 90
		view 530
		loop 6
		cel 3
		priority 4
		signal $1810
	)
)

(instance extra5 of PicView
	(properties
		x 140
		y 77
		description {pár}
		sightAngle 90
		view 530
		loop 6
		cel 4
		priority 5
		signal $1810
	)
)

(instance michelle of Prop
	(properties
		x 237
		y 143
		z 40
		description {ona}
		view 530
		loop 5
		priority 1
		signal $0810
	)
	
	(method (doVerb theVerb param2)
		(theTable doVerb: theVerb param2)
	)
)

(instance chair of Feature
	(properties
		x 179
		y 144
		nsTop 126
		nsLeft 162
		nsBottom 163
		nsRight 196
		description {tvoje židle}
		sightAngle 40
		lookStr {Jediné místo, kde mùžeš sedìt. A líbí se ti!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 530 6))
			(1 (proc0_14 530 7))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cactus of Feature
	(properties
		x 91
		y 143
		nsTop 107
		nsLeft 43
		nsBottom 180
		nsRight 140
		description {kaktus}
		sightAngle 40
		onMeCheck $0004
		lookStr {Není to zvláštní, že tenhle kaktus kvete, když žádný jiný nekvete?}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_18 gLarry 530 8))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance table1 of Feature
	(properties
		x 67
		y 95
		nsTop 73
		nsLeft 45
		nsBottom 107
		nsRight 90
		description {stùl}
		sightAngle 40
		lookStr {Tady je další pár, který si užívá krásný veèer, zatímco ty se tu zase couráš úplnì sám!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 530 9))
			(5
				(if (not local1)
					(proc0_2)
					(proc0_18 gLarry 530 10 67 -1 185)
					(proc0_14 530 11 108 drape1)
				else
					(super doVerb: theVerb param2)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance table2 of Feature
	(properties
		x 132
		y 195
		nsTop 60
		nsLeft 109
		nsBottom 92
		nsRight 155
		description {stùl}
		sightAngle 40
		lookStr {Tady je další pár, který si užívá krásný veèer, zatímco ty se touláš po New Yorku úplnì sám!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 530 9))
			(5
				(if (not local2)
					(proc0_2)
					(proc0_18 gLarry 530 12 67 -1 185)
					(proc0_14 530 13 108 drape2)
				else
					(super doVerb: theVerb param2)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance table3 of Feature
	(properties
		x 187
		y 95
		nsTop 67
		nsLeft 173
		nsBottom 104
		nsRight 201
		description {stùl}
		sightAngle 40
		lookStr {Tady je další pár, který si užívá bájeèný veèer, zatímco ty se zase touláš po New Yorku úplnì sám!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 530 9))
			(5
				(if (not local3)
					(proc0_2)
					(proc0_18 gLarry 530 14 67 -1 185 108 drape3)
				else
					(super doVerb: theVerb param2)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance theTable of Feature
	(properties
		x 246
		y 140
		nsTop 75
		nsLeft 214
		nsBottom 132
		nsRight 279
		description {stùl}
		sightAngle 40
		lookStr {Úchvatnì krásná èernoška sedí sama u stolu a pomalu a smyslnì si pohrává se svým dezertem. Je to Michelle Milkenová. Našel jsi ji, Larry!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 530 15))
			(4 (proc0_14 530 16))
			(10 (proc0_14 530 17))
			(5
				(switch (++ local0)
					(1
						(proc0_18 gLarry 530 18 67 -1 185)
						(proc0_14 530 19)
						(proc0_18 Michelle_Milken 530 20 108)
					)
					(2
						(proc0_18 gLarry 530 21 67 -1 185)
						(global2 setScript: sTalk 0 0)
					)
					(3
						(proc0_18 gLarry 530 22 67 -1 185)
						(proc0_18 gLarry 530 23 67 -1 185)
						(global2 setScript: sTalk 0 1)
					)
					(4
						(proc0_18 gLarry 530 24 67 -1 185)
						(proc0_18 Michelle_Milken 530 25 108)
					)
					(else 
						(proc0_18 gLarry 530 26 67 -1 185)
						(global2 setScript: sTalk 0 2)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cart of Feature
	(properties
		x 206
		y 139
		nsTop 125
		nsLeft 188
		nsBottom 154
		nsRight 225
		description {servírovací vozík}
		sightAngle 40
		lookStr {Vypadá to, že tento vozík je jediný volný stùl.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 530 27))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 144
		y 140
		z 86
		nsTop 40
		nsLeft 121
		nsBottom 65
		nsRight 167
		description {lampa}
		sightAngle 40
		onMeCheck $0002
		lookStr {Vrhá rovnomìrné svìtlo.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sEnter of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setMotion: PolyPath 199 155 self)
			)
			(1
				(gLarry
					view: 531
					posn: 193 151
					setLoop: 0
					setCel: 0
					setCycle: 0
				)
				(= cycles 1)
			)
			(2
				(gLarry setLoop: 0 setCel: 1 setPri: 14)
				(= cycles 1)
			)
			(3
				(gLarry setLoop: 0 setCycle: End self)
			)
			(4
				(proc0_3)
				(User canControl: 0)
				(gIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sCloseCurtain of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== (gLongSong number?) 535)
				(== (gLongSong prevSignal?) 10)
			)
			(gLongSong number: 538 play:)
		)
	)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (proc0_2) (= seconds 2))
			(1 (drape4 setCycle: End self))
			(2 (= seconds 4))
			(3 (global2 newRoom: 535))
		)
	)
)

(instance sDoMichelle of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setCycle: Beg self)
			)
			(1
				(gLarry normalize: setMotion: PolyPath 260 143 self)
			)
			(2
				(gLarry view: 531 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(gLarry
					setCel: (gLarry cel?)
					setMotion: MoveTo 263 142 self
				)
			)
			(4 (= seconds 5))
			(5 (global2 newRoom: 535))
		)
	)
)

(instance sMichelleEating of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch (Random 1 4)
					(1 (= cycles (= state 1)))
					(2 (= seconds 4))
					(else 
						(= state 6)
						(= cycles 1)
					)
				)
			)
			(1 (self init:))
			(2
				(michelle setLoop: 4 setCel: 0 setCycle: End self)
			)
			(3 (= seconds (Random 2 4)))
			(4
				(michelle setCycle: Beg self)
			)
			(5 (= seconds 2))
			(6 (self init:))
			(7
				(michelle setLoop: 5 setCel: 0 setCycle: End self)
			)
			(8 (= seconds 2))
			(9 (self init:))
		)
	)
)

(instance sOpenCurtain of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(proc0_18 Michelle_Milken 530 28 108)
				(drape4 setCycle: Beg self)
			)
			(2
				(proc0_3)
				(gLarry normalize:)
			)
		)
	)
)

(instance drape1 of Prop
	(properties
		x 89
		y 36
		description {závìs}
		view 530
		loop 1
		priority 7
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 530 29))
			(3 (proc0_14 530 30))
			(5
				(if local1
					(switch (Random 1 3)
						(1 (proc0_14 530 31))
						(2 (proc0_14 530 32))
						(3 (proc0_14 530 33))
					)
				else
					(table1 doVerb: 5)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(self setCycle: End)
		(table1 dispose:)
		(extra1 dispose:)
		(extra2 dispose:)
		(= local1 1)
		(proc0_3)
		(User canControl: 0)
		(gIconBar disable: 0)
	)
)

(instance drape2 of Prop
	(properties
		x 134
		y 101
		description {závìs}
		view 530
		loop 3
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 530 30))
			(2 (proc0_14 530 29))
			(5
				(if local2 (drape1 doVerb: 5) else (table2 doVerb: 5))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(switch (++ local4)
			(1 (proc0_14 530 34 108 self))
			(2
				(self setCycle: End)
				(table2 dispose:)
				(extra4 dispose:)
				(extra5 dispose:)
				(= local2 1)
				(proc0_3)
				(User canControl: 0)
				(gIconBar disable: 0)
			)
		)
	)
)

(instance drape3 of Prop
	(properties
		x 211
		y 35
		description {závìs}
		view 530
		loop 2
		priority 7
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 530 30))
			(2 (proc0_14 530 29))
			(5
				(if local3 (drape1 doVerb: 5) else (table3 doVerb: 5))
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(proc0_14 530 35)
		(self setCycle: End)
		(table3 dispose:)
		(extra3 dispose:)
		(= local3 1)
		(proc0_3)
		(User canControl: 0)
		(gIconBar disable: 0)
	)
)

(instance drape4 of Prop
	(properties
		x 279
		y 55
		description {závìs}
		view 530
		priority 14
		signal $4010
	)
	
	(method (doVerb theVerb)
		(drape1 doVerb: theVerb)
	)
)

(instance Michelle_Milken of Talker
	(properties
		nsTop 15
		nsLeft 30
		view 1530
		loop 3
		viewInPrint 1
		name "Michelle Milken"
	)
	
	(method (init)
		(= bust talkerBust)
		(= eyes talkerEyes)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerBust of View
	(properties
		view 1530
		loop 1
	)
)

(instance talkerEyes of Prop
	(properties
		nsTop 27
		nsLeft 20
		view 1530
		loop 2
		cycleSpeed 30
	)
)

(instance talkerMouth of Prop
	(properties
		nsTop 37
		nsLeft 26
		view 1530
	)
)
