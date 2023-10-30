;;; Sierra Script 1.0 - (do not remove this comment)
(script# 280)
(include sci.sh)
(use Main)
(use LLRoom)
(use Polygon)
(use CueObj)
(use Sound)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm280 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 500]
)
(instance rm280 of LLRoom
	(properties
		lookStr {Tento konec vstupní haly je odlišený pouze øadou telefonních automatù u vzdálenìjší stìny.}
		picture 280
		west 270
	)
	
	(method (init)
		(gLarry init: normalize:)
		(switch gGNumber
			(west
				(if (and (> gBlondeX 330) (> gRedHeadX 330))
					(blonde
						init:
						view: 276
						setLoop: 2
						posn: 38 84
						setCycle: Fwd
						cycleSpeed: 6
						moveSpeed: 10
						setScript: sFight
					)
					(redHead init: hide:)
				else
					(blonde
						init:
						posn: (- gBlondeX 319) 82
						setLoop: gBlondeLoop
						setScript: sBlonde
					)
					(redHead
						init:
						posn: (- gRedHeadX 319) 82
						setLoop: gRedHeadLoop
						setScript: sRedHead
					)
				)
				(= style 12)
			)
			(else 
				(blonde
					init:
					x: (Random 8 22)
					y: 82
					setLoop: 4
					setScript: sBlonde
				)
				(redHead
					init:
					x: (Random 45 68)
					y: 82
					setLoop: 4
					setScript: sRedHead
				)
				(gLarry posn: 16 160 edgeHit: 0)
			)
		)
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
						0
						189
						0
						187
						316
						187
						315
						161
						264
						112
						124
						112
						120
						117
						83
						117
						68
						112
						0
						112
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 216 127 218 122 230 119 255 119 263 119 268 124 267 132 225 132
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 9 175 27 147 181 147 198 158 230 158 236 161 234 166 214 166 208 175
					yourself:
				)
		)
		(lostDesk init:)
		(largePlant init:)
		(smallPlant init:)
		(post init:)
		(ashtray init:)
		(theCounter init:)
		(sofa init:)
		(phones init: approachVerbs: 2 3 4)
		(phoneBook1 init: approachVerbs: 2 3 4)
		(phoneBook2 init: approachVerbs: 2 3 4)
		(Load rsSCRIPT 20)
		(switch global160
			(0
				(blonde description: {Buffi})
				(redHead description: {Muffi})
				(p1 init:)
				(p2 init:)
				(p3 init:)
				(p4 init:)
				(ph1 init:)
				(ph2 init:)
				(ph3 init:)
				(ph4 init:)
				(ad1 loop: 8 cel: 0 init:)
				(ad2 loop: 8 cel: 1 init:)
				(ad3 loop: 8 cel: 2 init:)
				(ad4 loop: 8 cel: 3 init:)
			)
			(1
				(blonde description: {Tracie})
				(redHead description: {Stacie})
				(thePhone
					init:
					x: 155
					y: 80
					heading: 0
					nsLeft: 147
					nsTop: 70
					nsBottom: 91
					nsRight: 163
					approachX: 138
					approachY: 113
				)
				(phoneHandle init: posn: 152 85)
				(p2 init:)
				(p3 init:)
				(p4 init:)
				(ph2 init:)
				(ph3 init:)
				(ph4 init:)
				(ad1 loop: 9 cel: 0 init:)
				(ad2 loop: 9 cel: 1 init:)
				(ad3 loop: 9 cel: 2 init:)
				(ad4 loop: 9 cel: 3 init:)
			)
			(2
				(blonde description: {Cherri})
				(redHead description: {Barri})
				(thePhone
					init:
					x: 176
					y: 80
					heading: 0
					nsLeft: 169
					nsTop: 70
					nsBottom: 91
					nsRight: 183
					approachX: 160
					approachY: 113
				)
				(phoneHandle init: posn: 173 85)
				(p1 init:)
				(p3 init:)
				(p4 init:)
				(ph1 init:)
				(ph3 init:)
				(ph4 init:)
				(ad1 loop: 10 cel: 0 init:)
				(ad2 loop: 10 cel: 1 init:)
				(ad3 loop: 10 cel: 2 init:)
				(ad4 loop: 10 cel: 3 init:)
			)
			(3
				(blonde description: {Dixie})
				(redHead description: {Trixie})
				(thePhone
					init:
					x: 200
					y: 80
					heading: 0
					nsLeft: 192
					nsTop: 70
					nsBottom: 91
					nsRight: 206
					approachX: 183
					approachY: 113
				)
				(phoneHandle init: posn: 196 85)
				(p1 init:)
				(p2 init:)
				(p4 init:)
				(ph1 init:)
				(ph2 init:)
				(ph4 init:)
				(ad1 loop: 11 cel: 0 init:)
				(ad2 loop: 11 cel: 1 init:)
				(ad3 loop: 11 cel: 2 init:)
				(ad4 loop: 11 cel: 3 init:)
			)
		)
		(gAddToPics doit:)
		(proc0_3)
		(proc0_17 (Random 40 120) 0 self)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(gLarry mover?)
				(== (gLarry view?) 550)
				(< (gLarry loop?) 8)
			)
			(switch (gLarry cel?)
				(1
					(if (!= (stepSound number?) 260)
						(stepSound number: 260 play:)
					)
				)
				(4
					(if (!= (stepSound number?) 261)
						(stepSound number: 261 play:)
					)
				)
			)
		)
		(cond 
			(script)
			((== (gLarry edgeHit?) 4)
				(= gRedHeadX (redHead x?))
				(= gRedHeadLoop (redHead loop?))
				(= gBlondeX (blonde x?))
				(= gBlondeLoop (blonde loop?))
			)
			((gLarry inRect: -3 105 86 124)
				(if (and (not local5) (not local0))
					(= local0 1)
					(blonde setScript: sBlonde 0 -100)
				)
				(if (and (not local5) (not local1))
					(= local1 1)
					(redHead setScript: sRedHead 0 -100)
				)
			)
		)
	)
	
	(method (doVerb theVerb &tmp [temp0 100])
		(switch theVerb
			(2
				(Format
					@temp0
					280
					0
					(switch global160
						(0 {Los Angeles})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
				)
				(proc0_14 @temp0)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(if (not local4)
			(announcement
				number: (Random 273 275)
				setLoop: 1
				flags: 1
				play:
			)
		)
		(proc0_17 (Random 20 40) 2 self)
	)
	
	(method (newRoom newRoomNumber)
		(blonde dispose:)
		(redHead dispose:)
		(gLl5Timer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
	
	(method (notify param1)
		(= local2 param1)
		(switch param1
			(4668
				(cond 
					((!= global160 1) (global2 setScript: sPhone 0 50))
					((not (proc0_6 1)) (= local3 1) (global2 setScript: sPhone 0 10))
					(else (proc0_14 280 1) (global2 setScript: sPhone 0 60))
				)
			)
			(4468
				(cond 
					((!= global160 2) (global2 setScript: sPhone 0 50))
					((not (proc0_6 1)) (= local3 1) (global2 setScript: sPhone 0 30))
					(else (proc0_14 280 1) (global2 setScript: sPhone 0 60))
				)
			)
			(8544
				(cond 
					((!= global160 3) (global2 setScript: sPhone 0 50))
					((and (not (proc0_6 8)) (not (proc0_6 1))) (= local3 1) (global2 setScript: sPhone 0 20))
					(else (proc0_14 280 1) (global2 setScript: sPhone 0 60))
				)
			)
			(1272
				(cond 
					((!= global160 3) (global2 setScript: sPhone 0 50))
					((not (proc0_6 12)) (= local3 1) (global2 setScript: sPhone 0 40))
					(else (proc0_14 280 1) (global2 setScript: sPhone 0 60))
				)
			)
			(3627
				(if (== global160 3)
					(proc0_14 280 1)
					(global2 setScript: sPhone 0 60)
				else
					(proc0_14 280 2)
					(global2 setScript: sPhone 0 60)
				)
			)
			(-1
				(proc0_14 280 3)
				(global2 setScript: sPhone 0 60)
			)
			(else 
				(proc0_14 280 2)
				(global2 setScript: sPhone 0 60)
			)
		)
	)
)

(instance lostDesk of Feature
	(properties
		x 300
		y 91
		nsTop 55
		nsLeft 282
		nsBottom 128
		nsRight 319
		description {oddìlení ztrát a nálezù}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 280 4))
			(3 (proc0_14 280 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance largePlant of Feature
	(properties
		y 1
		nsTop 72
		nsLeft 76
		nsBottom 113
		nsRight 123
		description {rostlina}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 280 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance smallPlant of Feature
	(properties
		y 1
		nsTop 167
		nsLeft 256
		nsBottom 189
		nsRight 319
		description {rostlina}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 280 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance post of Feature
	(properties
		y 1
		nsLeft 225
		nsBottom 129
		nsRight 258
		description {pošta}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 280 7))
			(3 (proc0_14 280 8))
			(5 (proc0_14 280 9))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ashtray of Feature
	(properties
		x 216
		y 150
		nsTop 136
		nsLeft 207
		nsBottom 164
		nsRight 226
		description {popelník}
		sightAngle 90
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 30])
		(switch theVerb
			(2 (proc0_14 280 10))
			(3
				(if (not (Random 0 1))
					(proc0_14 280 11)
				else
					(proc0_14 280 12)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance theCounter of Feature
	(properties
		x 43
		y 65
		nsTop 41
		nsBottom 89
		nsRight 87
		description {pult}
		sightAngle 90
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(Format
					@local6
					280
					13
					(blonde description?)
					(redHead description?)
				)
				(proc0_14 @local6)
			)
			(3
				(Format
					@local6
					280
					14
					(blonde description?)
					(redHead description?)
				)
				(proc0_14 @local6)
				(proc0_14 280 15 67 -1 185)
			)
			(5 (proc0_14 280 16))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sofa of Feature
	(properties
		x 113
		y 153
		nsTop 127
		nsLeft 25
		nsBottom 180
		nsRight 202
		description {pohovka}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 280 17))
			(3 (proc0_14 280 18))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance blonde of Actor
	(properties
		sightAngle 40
		view 277
		signal $4000
		illegalBits $0000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(Format @local6 280 19 (blonde description?))
				(proc0_14 @local6)
			)
			(3
				(Format @local6 280 20 (blonde description?))
				(proc0_14 @local6)
			)
			(5
				(proc0_14 280 21)
				(proc0_14 280 22)
			)
			(4
				(Format @local6 280 23 (blonde description?))
				(proc0_14 @local6)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance redHead of Actor
	(properties
		sightAngle 90
		view 276
		signal $4000
		illegalBits $0000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(Format @local6 280 24 (redHead description?))
				(proc0_14 @local6)
				(proc0_14 280 25)
			)
			(3
				(proc0_14 280 26)
				(proc0_14 280 27)
			)
			(5
				(proc0_14 280 21)
				(proc0_14 280 28)
			)
			(4
				(Format @local6 280 23 (redHead description?))
				(proc0_14 @local6)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sRedHead of Script
	(properties)
	
	(method (changeState newState &tmp theRegister redHeadX)
		(switch (= state newState)
			(0
				(= redHeadX (redHead x?))
				(if register
					(= theRegister register)
				else
					(switch (Random 1 2)
						(1
							(= theRegister (Random 8 65))
						)
						(2
							(= theRegister (Random -100 -12))
						)
					)
				)
				(if
					(and
						(not register)
						(or
							(and
								(< theRegister (blonde x?))
								(< (blonde x?) redHeadX)
							)
							(and
								(< redHeadX (blonde x?))
								(< (blonde x?) theRegister)
							)
						)
					)
					(= cycles 1)
				else
					(redHead
						setLoop: -1
						setCycle: Fwd
						setMotion: MoveTo theRegister 82 self
					)
				)
			)
			(1
				(redHead setLoop: 4 setCycle: 0 setMotion: 0)
				(= seconds (Random 3 7))
			)
			(2
				(= local1 (= register 0))
				(self init:)
			)
		)
	)
)

(instance sBlonde of Script
	(properties)
	
	(method (changeState newState &tmp theRegister blondeX)
		(switch (= state newState)
			(0
				(= blondeX (blonde x?))
				(if register
					(= theRegister register)
				else
					(switch (Random 1 2)
						(1
							(= theRegister (Random 8 65))
						)
						(2
							(= theRegister (Random -100 -12))
						)
					)
				)
				(if
					(and
						(not register)
						(or
							(and
								(< theRegister (redHead x?))
								(< (redHead x?) blondeX)
							)
							(and
								(< blondeX (redHead x?))
								(< (redHead x?) theRegister)
							)
						)
					)
					(= cycles 1)
				else
					(blonde
						setLoop: -1
						setCycle: Fwd
						setMotion: MoveTo theRegister 82 self
					)
				)
			)
			(1
				(blonde setLoop: 3 setCycle: 0 setMotion: 0)
				(= seconds (Random 3 7))
			)
			(2
				(= local0 (= register 0))
				(self init:)
			)
		)
	)
)

(instance thePhone of Feature
	(properties
		description {telefonní automat}
		sightAngle 40
	)
	
	(method (init)
		(self approachVerbs: 4 3 5 2)
		(super init:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 280 29))
			(3
				(if (gLarry has: 10)
					(proc0_14 280 30)
					(global2 setScript: sPhone)
				else
					(proc0_14 280 31)
				)
			)
			(4
				(if (== param2 10)
					(global2 setScript: sPhone)
				else
					(proc0_14 280 32)
				)
			)
			(5 (proc0_14 280 31))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance phoneHandle of View
	(properties
		description {telefonní automat}
		view 280
		cel 1
		priority 4
		signal $4010
	)
	
	(method (init)
		(self
			approachVerbs: 4 3 5 2
			approachX: (thePhone approachX?)
			approachY: (thePhone approachY?)
		)
		(super init:)
	)
	
	(method (doVerb)
		(thePhone doVerb: &rest)
	)
)

(instance p1 of Feature
	(properties
		x 153
		y 80
		nsTop 70
		nsLeft 145
		nsBottom 90
		nsRight 162
		description {telefon}
		sightAngle 40
	)
	
	(method (init)
		(self approachVerbs: 2 3 4)
		(super init:)
	)
	
	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance p2 of Feature
	(properties
		x 175
		y 80
		nsTop 70
		nsLeft 167
		nsBottom 90
		nsRight 183
		description {telefon}
		sightAngle 40
	)
	
	(method (init)
		(self approachVerbs: 2 3 4)
		(super init:)
	)
	
	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance p3 of Feature
	(properties
		x 199
		y 80
		nsTop 70
		nsLeft 193
		nsBottom 91
		nsRight 206
		description {telefon}
		sightAngle 40
	)
	
	(method (init)
		(self approachVerbs: 2 3 4)
		(super init:)
	)
	
	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance p4 of Feature
	(properties
		x 221
		y 80
		nsTop 70
		nsLeft 214
		nsBottom 91
		nsRight 228
		description {telefon}
		sightAngle 40
	)
	
	(method (init)
		(self approachVerbs: 2 3 4)
		(super init:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 280 33))
			(3 (proc0_14 280 34))
			(4
				(if (== param2 10)
					(proc0_14 280 35)
				else
					(proc0_14 280 32)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ph1 of PicView
	(properties
		x 152
		y 85
		view 280
		cel 1
	)
	
	(method (init)
		(self approachVerbs: 2 3 4)
		(super init:)
	)
	
	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance ph2 of PicView
	(properties
		x 173
		y 85
		view 280
		cel 1
	)
	
	(method (init)
		(self approachVerbs: 2 3 4)
		(super init:)
	)
	
	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance ph3 of PicView
	(properties
		x 196
		y 85
		view 280
		cel 1
	)
	
	(method (init)
		(self approachVerbs: 2 3 4)
		(super init:)
	)
	
	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance ph4 of PicView
	(properties
		x 218
		y 85
		view 280
		cel 1
	)
	
	(method (init)
		(self approachVerbs: 2 3 4)
		(super init:)
	)
	
	(method (doVerb)
		(p4 doVerb: &rest)
	)
)

(instance ad1 of PicView
	(properties
		x 21
		y 9
		nsBottom 14
		nsRight 47
		description {znaèka}
		sightAngle 90
		view 263
		priority 4
		signal $7810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 280 36))
					(1 (proc0_14 280 37))
					(2 (proc0_14 280 38))
					(3 (proc0_14 280 39))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ad2 of PicView
	(properties
		x 98
		y 9
		nsLeft 62
		nsBottom 15
		nsRight 134
		description {znaèka}
		sightAngle 90
		view 263
		priority 4
		signal $7810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 280 40))
					(1 (proc0_14 280 41 30 1))
					(2 (proc0_14 280 42))
					(3
						(proc0_10 1 96)
						(proc0_14 280 43)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ad3 of PicView
	(properties
		x 183
		y 11
		nsLeft 148
		nsBottom 16
		nsRight 221
		description {znaèka}
		sightAngle 90
		view 263
		priority 4
		signal $7810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 280 44))
					(1 (proc0_14 280 45))
					(2 (proc0_14 280 46))
					(3 (proc0_14 280 47))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance ad4 of PicView
	(properties
		x 314
		y 23
		nsLeft 295
		nsBottom 31
		nsRight 319
		description {znaèka}
		sightAngle 90
		view 263
		priority 4
		signal $7810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(switch global160
					(0 (proc0_14 280 48))
					(1 (proc0_14 280 49))
					(2 (proc0_14 280 50))
					(3 (proc0_14 280 51))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance stepSound of Sound
	(properties)
)

(instance announcement of Sound
	(properties)
)

(instance phoneBook1 of Feature
	(properties
		x 169
		y 91
		nsTop 86
		nsLeft 160
		nsBottom 97
		nsRight 176
		description {telefonní seznam}
		sightAngle 40
		onMeCheck $0002
		approachX 169
		approachY 112
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 280 52))
			(3
				(proc0_14 280 53)
				(proc0_14 280 54)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance phoneBook2 of Feature
	(properties
		x 207
		y 91
		nsTop 87
		nsLeft 200
		nsBottom 96
		nsRight 214
		description {telefonní seznam}
		sightAngle 40
		onMeCheck $0002
		approachX 207
		approachY 112
	)
	
	(method (doVerb theVerb param2)
		(phoneBook1 doVerb: theVerb &rest)
	)
)

(instance sFight of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= local5 1) (= cycles 2))
			(1
				(proc0_2)
				(blonde setMotion: MoveTo -40 84 self)
			)
			(2
				(blonde
					view: 277
					posn: -40 82
					setScript: sBlonde
					ignoreActors: 1
					setLoop: 0
				)
				(redHead
					view: 276
					posn: -70 82
					setLoop: 0
					setScript: sRedHead
					ignoreActors: 1
					show:
				)
				(proc0_3)
				(= local5 0)
				(self dispose:)
			)
		)
	)
)

(instance sPhone of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2] [temp2 80])
		(switch (= state newState)
			(0
				(proc0_2)
				(= local4 1)
				(if (not register)
					(gLarry
						view: 281
						setLoop: 0
						setCel: 0
						cycleSpeed: 10
						setCycle: CT 4 1 self
					)
				else
					(self changeState: register)
				)
			)
			(1
				(gLongSong2 number: 36 loop: 1 play:)
				(phoneHandle hide:)
				(gLarry setCycle: End self)
			)
			(2
				(User canInput: 1)
				((ScriptID 20 0) init: 1)
			)
			(10
				(proc0_10 3 1)
				(proc0_7 38)
				(proc0_14 280 55 67 -1 20)
				(= ticks 30)
			)
			(11
				(proc0_14 280 56)
				(= ticks 30)
			)
			(12
				(proc0_14 280 57 67 -1 20)
				(= ticks 30)
			)
			(13
				(proc0_14 280 58)
				(= ticks 30)
			)
			(14
				(proc0_14 280 59 67 -1 20)
				(= ticks 30)
			)
			(15
				(proc0_14 280 60)
				(= ticks 30)
			)
			(16
				(proc0_14 280 61 67 -1 20)
				(= ticks 30)
			)
			(17
				(proc0_14 280 62 67 -1 185)
				(self changeState: 60)
			)
			(20
				(proc0_10 3 1)
				(proc0_7 38)
				(proc0_14 280 63 67 -1 20)
				(= ticks 30)
			)
			(21
				(proc0_14 280 64)
				(= ticks 30)
			)
			(22
				(proc0_14 280 65 67 -1 20)
				(= ticks 30)
			)
			(23
				(proc0_14 280 66)
				(= ticks 30)
			)
			(24
				(proc0_14 280 67 67 -1 20)
				(proc0_14 280 68 67 -1 20)
				(= ticks 30)
			)
			(25
				(proc0_14 280 62 67 -1 185)
				(self changeState: 60)
			)
			(30
				(proc0_10 3 1)
				(proc0_7 38)
				(proc0_14 280 69 67 -1 20)
				(= ticks 30)
			)
			(31
				(proc0_14 280 70)
				(= ticks 30)
			)
			(32
				(proc0_14 280 71 67 -1 20)
				(= ticks 30)
			)
			(33
				(proc0_14 280 62 67 -1 185)
				(self changeState: 60)
			)
			(40
				(proc0_10 7 12)
				(proc0_7 38)
				(proc0_14 280 72)
				(= ticks 30)
			)
			(41
				(proc0_14 280 73)
				(= ticks 30)
			)
			(42
				(proc0_14 280 74)
				(= ticks 30)
			)
			(43
				(proc0_14 280 62 67 -1 185)
				(self changeState: 60)
			)
			(50
				(proc0_14 280 75)
				(= ticks 30)
			)
			(51
				(Format
					@temp2
					280
					76
					(switch local2
						(3627 {Miami})
						(4668 {New York City})
						(4468 {Atlantic City})
						(8544 {Miami})
						(1272 {Miami})
					)
				)
				(proc0_14 @temp2 67 -1 185)
				(= ticks 30)
			)
			(52 (self changeState: 60))
			(60 (= ticks 10))
			(61
				(gLarry setCycle: CT 4 -1 self)
			)
			(62
				(phoneHandle show:)
				(gLarry setCycle: Beg self)
			)
			(63
				(gLongSong2 number: 37 loop: 1 play:)
				(if (and local3 (not (-- global168)))
					(= global168 -1)
					(gLarry put: 10)
				)
				(gLarry setLoop: 3 normalize:)
				(= local3 0)
				(= local4 (= register 0))
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance phones of PicView
	(properties
		x 185
		y 1
		z -100
		description {telefonní automaty}
		approachX 180
		approachY 112
		view 280
		priority 0
		signal $4010
	)
	
	(method (onMe)
		(return 0)
	)
)
