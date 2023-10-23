;;; Sierra Script 1.0 - (do not remove this comment)
(script# 320)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use n940)
(use RandCycle)
(use CueObj)
(use Sound)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm320 0
)

(local
	local0
	local1
	local2
	local3
)
(procedure (localproc_10e6)
	(if gTheNewDialog (gTheNewDialog dispose:))
	(proc0_3)
	(User canControl: 0)
	(gIconBar disable: 0)
)

(instance rm320 of LLRoom
	(properties
		picture 320
		style $0007
	)
	
	(method (init)
		(if (== gGNumber 101)
			(switch
				(= local3
					(proc940_0
						{Enter dream to debug:}
						106
						81
						{Dream of Athens}
						1
						106
						81
						{Wake up from Athens}
						5
						106
						81
						{Dream of Venice}
						2
						106
						81
						{Wake up from Venice}
						6
						106
						81
						{Dream of Taj Mahal}
						3
						106
						81
						{Wake up from Taj Mahal}
						7
						106
						81
						{Dream of Casablanca}
						4
					)
				)
				(1 (= global156 0))
				(2 (= global156 1))
				(3 (= global156 2))
				(4 (= global156 3))
				(5
					(= gGNumber 200)
					(= global156 0)
				)
				(6
					(= gGNumber 200)
					(= global156 1)
				)
				(7
					(= gGNumber 200)
					(= global156 2)
				)
			)
		)
		(super init:)
		(if (!= gGNumber 200)
			(gLongSong number: 321 loop: -1 play:)
		)
		(cloud
			init:
			setStep: 1 1
			posn: 244 (Random 30 44)
			setMotion: MoveTo 63 (cloud y?) cloud
		)
		(switch gGNumber
			(200
				(Load rsSOUND 312)
				(= local1 1)
				(switch global156
					(0
						(larry init: setCel: 1 stopUpd:)
						(if (== global157 1)
							(= global156 1)
						else
							(= global156 2)
						)
						(Load rsSOUND 347)
						(self setScript: sWakeUpAthens)
					)
					(1
						(larry init: setCel: 1 stopUpd:)
						(if (and (proc0_6 28) (proc0_6 29))
							(= global156 3)
						else
							(= global156 2)
						)
						(self setScript: sWakeUpVenice)
					)
					(2
						(if (and (proc0_6 28) (proc0_6 29))
							(= global156 3)
						else
							(= global156 1)
						)
						(self setScript: sWakeUpTaj)
					)
				)
			)
			(else 
				(Load rsVIEW 322)
				(larry init: stopUpd:)
				(body init: stopUpd:)
				(arm init: stopUpd:)
				(tray init: stopUpd:)
				(arm2 init: stopUpd:)
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(theMagazine init:)
					(magazine init:)
				)
				(self setScript: sFlyingCoach)
			)
		)
		(proc0_2)
	)
	
	(method (doit)
		(super doit:)
		(if local1 (Palette 6 local2 (+ local2 7) 6))
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 320 0)
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(proc0_14 320 1)
				)
			)
			(5 (proc0_14 320 2))
			(3 (proc0_14 320 3))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sFlyingCoach of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 3))
			(1
				(User canInput: 1)
				(Load rsSOUND 320)
				(switch global156
					(0
						(proc0_13 400)
						(Load rsVIEW 330)
						(Load rsVIEW 335)
						(Load rsVIEW 341)
						(Load rsPIC 330)
						(Load rsPIC 335)
						(Load rsPIC 340)
						(Load rsSOUND 330)
					)
					(1
						(proc0_13 600)
						(Load rsVIEW 350)
						(Load rsVIEW 351)
						(Load rsVIEW 321)
						(Load rsVIEW 356)
						(Load rsPIC 350)
						(Load rsPIC 355)
					)
					(2
						(proc0_13 800)
						(Load rsVIEW 370)
						(Load rsVIEW 371)
						(Load rsPIC 370)
						(Load rsSOUND 370)
					)
					(3
						(proc0_13 385)
						(Load rsVIEW 380)
						(Load rsPIC 380)
					)
				)
				(localproc_10e6)
				(= seconds (Random 10 20))
			)
			(2
				(proc0_2)
				(larry setCel: 1)
				(gLongSong number: 321 fade: 0 15 10 1)
				(gLongSong2
					number: 320
					loop: -1
					play: 10
					fade: 127 15 5 0
				)
				(= seconds 3)
			)
			(3
				(larry addToPic: dispose:)
				(= seconds 2)
			)
			(4
				(dreamProp1 init: view: 322 setCel: 1 posn: 146 37)
				(= ticks 40)
			)
			(5
				(dreamProp1 setCel: 2 posn: 171 51)
				(= ticks 40)
			)
			(6
				(dreamProp1 setCel: 3 posn: 195 78)
				(gLongSong2 fade: 0 15 5 1)
				(= ticks 60)
			)
			(7
				(switch global156
					(0
						(gLongSong number: 330 loop: 1 play: 30 fade: 127 15 10 0)
					)
					(1
						(gLongSong
							number: 350
							loop: -1
							play: 30
							fade: 127 15 10 0
						)
					)
					(2
						(gLongSong2
							number: 370
							loop: -1
							play: 30
							fade: 127 15 10 0
						)
					)
					(3
						(gLongSong
							number: 381
							loop: -1
							play: 30
							fade: 127 15 10 0
						)
					)
				)
				(= ticks 40)
			)
			(8
				(dreamProp1 setCel: 4 posn: 201 122)
				(= ticks 30)
			)
			(9
				(= local1 1)
				(switch global156
					(0
						(self setScript: sDreamAthens)
					)
					(1
						(self setScript: sDreamVenice)
					)
					(2 (self setScript: sDreamTaj))
					(3 (self setScript: sDreamCasa))
				)
			)
		)
	)
)

(instance larry of Actor
	(properties
		x 134
		y 70
		description {your head}
		view 321
		loop 1
		priority 4
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 320 4)
				(proc0_14 320 5 67 -1 185)
			)
			(5 (proc0_14 320 6))
			(3
				(proc0_14 320 7)
				(proc0_14 320 8 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance tray of Prop
	(properties
		x 202
		y 204
		z 100
		description {the tray}
		view 325
		loop 4
		priority 4
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 320 9))
			(5 (proc0_14 320 10))
			(3 (proc0_14 320 11))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (onMe param1)
		(proc999_4 164 80 199 96 param1)
	)
)

(instance arm of Prop
	(properties
		x 126
		y 79
		description {your arm}
		lookStr {You've always liked this arm.}
		view 321
		loop 2
		priority 5
		signal $4810
	)
)

(instance arm2 of Prop
	(properties
		x 173
		y 84
		description {your arm}
		lookStr {You've always liked this arm.}
		view 321
		loop 2
		cel 1
		priority 5
		signal $4810
	)
)

(instance body of Prop
	(properties
		x 165
		y 125
		description {your body}
		view 321
		priority 2
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 320 12)
				(proc0_14 320 13 67 -1 185)
			)
			(5
				(larry doVerb: theVerb param2)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cloud of Actor
	(properties
		x 244
		y 44
		description {the cloud}
		view 320
		loop 1
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 320 14))
			(3 (proc0_14 320 15))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(switch (++ local0)
			(1
				(proc0_17 (Random 2 5) 0 self)
			)
			(2
				(= local0 0)
				(cloud
					posn: 244 (Random 30 44)
					setMotion: MoveTo 63 (cloud y?) self
				)
			)
		)
	)
)

(instance patti of Prop
	(properties
		view 320
		priority 14
		signal $4810
	)
)

(instance dreamProp1 of Prop
	(properties
		view 320
		priority 14
		signal $4810
	)
)

(instance dreamProp2 of Prop
	(properties
		view 320
		priority 14
		signal $4810
	)
)

(instance dreamProp3 of Prop
	(properties
		view 320
		priority 14
		signal $4810
	)
)

(instance dreamProp4 of Prop
	(properties
		view 320
		priority 14
		signal $4810
	)
)

(instance dreamProp5 of Prop
	(properties
		view 320
		priority 14
		signal $4810
	)
)

(instance conf of Prop
	(properties
		x 181
		y 74
		view 340
		priority 14
		signal $4810
	)
	
	(method (cue)
		(super cue:)
		(switch (Random 1 10)
			(1
				(self
					show:
					setLoop: 0
					posn: 181 74
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(self
					show:
					setLoop: 0
					posn: 219 77
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(self
					show:
					setLoop: 0
					posn: 246 73
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(self
					show:
					setLoop: 1
					posn: 169 74
					setCel: 0
					setCycle: End self
				)
			)
			(5
				(self
					show:
					setLoop: 1
					posn: 212 78
					setCel: 0
					setCycle: End self
				)
			)
			(6
				(self
					show:
					setLoop: 1
					posn: 227 65
					setCel: 0
					setCycle: End self
				)
			)
			(else 
				(self hide:)
				(proc0_17 (Random 2 6) 1 self)
			)
		)
	)
)

(instance sSqeezeNuts of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMusic3 number: 322 loop: 1 play: self)
				(arm setCycle: End)
				(arm2 setCycle: End)
			)
			(1
				(arm setCel: 0)
				(arm2 setCel: 0)
				(= ticks 30)
			)
			(2 (self init:))
		)
	)
)

(instance magazine of View
	(properties
		x 208
		y 114
		description {the airline magazine}
		view 320
		priority 1
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 320 16))
			(3
				(gLarry get: 9)
				(theMagazine dispose:)
				(proc0_10 8)
				(proc0_14 320 17)
				(magazine dispose:)
				(self dispose:)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance MyForward of Fwd
	(properties)
	
	(method (cycleDone)
		(client cycleSpeed: (Random 6 10))
		(super cycleDone: &rest)
	)
)

(instance sDreamAthens of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (not state)
			(switch (gLongSong prevSignal?)
				(10
					(gLongSong prevSignal: 0)
					(patti setCycle: 0)
				)
				(-1
					(gLongSong prevSignal: 0)
					(self cue:)
				)
			)
		)
	)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(magazine dispose:)
				)
				(dreamProp1 dispose:)
				(body dispose:)
				(arm dispose:)
				(tray dispose:)
				(cloud dispose:)
				(arm2 dispose:)
				(patti
					init:
					view: 330
					posn: 172 125
					cycleSpeed: 10
					setCycle: RandCycle
				)
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= local2 40)
				(global2 overlay: 330)
			)
			(1
				(= local1 0)
				(global2 drawPic: (global2 picture?))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(larry init: addToPic: dispose:)
				(= local2 40)
				(global2 overlay: 335)
				(patti view: 335 posn: 213 88 setCycle: 0)
				(gLongSong2 number: 331 loop: -1 play:)
				(= ticks 10)
			)
			(2 (= local1 1) (= seconds 8))
			(3
				(= local1 0)
				(global2 drawPic: (global2 picture?))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(larry init: addToPic: dispose:)
				(= local2 56)
				(global2 overlay: 340)
				(patti
					view: 341
					setLoop: 0
					posn: 197 89
					setCel: 0
					setCycle: End
				)
				(conf init: setCycle: End conf)
				(= ticks 10)
			)
			(4
				(= local1 1)
				(dreamProp2
					init:
					view: 341
					setLoop: 3
					setCel: 0
					posn: 252 67
				)
				(= ticks 2)
			)
			(5
				(dreamProp2 setCel: 1 posn: 252 67)
				(= ticks 2)
			)
			(6
				(dreamProp2 setCel: 2 posn: 224 87)
				(= ticks 2)
			)
			(7
				(dreamProp2 setCel: 3 posn: 213 102 addToPic: dispose:)
				(= seconds 3)
			)
			(8
				(patti setCycle: Beg)
				(dreamProp3
					init:
					view: 341
					setLoop: 4
					setCel: 3
					posn: 163 63
				)
				(= ticks 2)
			)
			(9
				(dreamProp3 setCel: 4 posn: 169 70)
				(= ticks 2)
			)
			(10
				(dreamProp3 setCel: 5 posn: 177 78)
				(= ticks 2)
			)
			(11
				(dreamProp3 setCel: 6 posn: 184 88 addToPic: dispose:)
				(= seconds 3)
			)
			(12
				(patti setLoop: 1 setCel: 0 setCycle: End)
				(dreamProp4
					init:
					view: 341
					setLoop: 5
					setCel: 3
					posn: 205 69
				)
				(= ticks 2)
			)
			(13
				(dreamProp4 setCel: 4 posn: 215 78)
				(= ticks 2)
			)
			(14
				(dreamProp4 setCel: 5 posn: 230 91)
				(= ticks 2)
			)
			(15
				(dreamProp4 setCel: 6 posn: 236 103)
				(= seconds 2)
			)
			(16
				(patti setCycle: Beg)
				(conf dispose:)
				(= local1 0)
				(gLongSong fade: 0 15 10 1)
				(gLongSong2 fade: 0 15 10 1)
				(= seconds 2)
			)
			(17 (global2 newRoom: 400))
		)
	)
)

(instance sWakeUpAthens of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_13 310)
				(cloud hide:)
				(global2 drawPic: (global2 picture?))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= local2 56)
				(global2 overlay: 345)
				(gLongSong2 number: 345 loop: 1 play:)
				(dreamProp2
					init:
					view: 345
					posn: 168 118
					setPri: 13
					setLoop: 0
					signal: 18448
				)
				(dreamProp4
					init:
					view: 345
					setLoop: 1
					posn: 168 118
					cycleSpeed: 10
					setPri: 14
					setCel: -1
					signal: 18448
				)
				(patti
					init:
					view: 346
					posn: 209 140
					cycleSpeed: 8
					setPri: 13
					setLoop: 0
					setCel: -1
				)
				(dreamProp1
					init:
					view: 346
					setLoop: 2
					posn: 209 140
					setPri: 13
					setCel: -1
					signal: 18448
				)
				(= ticks 60)
			)
			(1
				(proc0_14 320 18 67 -1 185 70 280)
				(dreamProp4 setLoop: 1 cycleSpeed: 10 setCycle: Fwd)
				(= seconds 2)
			)
			(2 (= seconds 2))
			(3
				(dreamProp2 cycleSpeed: 10 setCycle: End)
				(dreamProp4 setLoop: 2 cycleSpeed: 10 setCycle: End)
				(dreamProp3
					init:
					view: 346
					setLoop: 1
					posn: 208 104
					setPri: 14
					setCel: 0
					signal: 18448
				)
				(dreamProp1 cycleSpeed: 10 setPri: 13 setCycle: End self)
				(zipperSound play:)
			)
			(4
				(dreamProp4 setLoop: 3 cycleSpeed: 10 setCycle: End)
				(patti setCycle: End)
				(dreamProp1 hide:)
				(dreamProp3 setPri: 14 cycleSpeed: 10 setCycle: End self)
			)
			(5
				(dreamProp1
					view: 346
					setLoop: 3
					posn: 209 140
					setCel: -1
					setCycle: Fwd
					setPri: 14
					show:
				)
				(= cycles 30)
			)
			(6
				(if gTheNewDialog (gTheNewDialog dispose:))
				(= local1 0)
				(global2 drawPic: (global2 picture?))
				(body init: stopUpd:)
				(tray init: stopUpd:)
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(magazine init:)
				)
				(patti dispose:)
				(dreamProp1 dispose:)
				(dreamProp2 dispose:)
				(dreamProp3 dispose:)
				(dreamProp4 dispose:)
				(gLongSong number: 321 loop: -1 play:)
				(gLongSong2
					number: 346
					loop: 1
					play: 60
					fade: 127 15 10 0
				)
				(arm
					init:
					view: 323
					setLoop: 1
					posn: 122 86
					setPri: 14
					ignoreActors: 1
					cycleSpeed: 10
					setScript: sSqeezeNuts
				)
				(arm2
					init:
					view: 323
					setLoop: 0
					posn: 138 78
					setPri: 5
					cycleSpeed: 10
					ignoreActors: 1
				)
				(larry
					init:
					view: 321
					loop: 1
					setCel: 1
					posn: 135 72
					setPri: 4
					signal: 18448
				)
				(= seconds 3)
			)
			(7
				(proc0_14 320 19 67 -1 15 70 280)
				(larry view: 325 setLoop: 1)
				(proc0_14 320 20 67 -1 185 80 {The Stewardess} 108 self)
				(arm setScript: 0)
			)
			(8
				(larry setCel: 1 cycleSpeed: 10 setCycle: CT 7 1 self)
			)
			(9 (= seconds 7))
			(10
				(arm
					view: 321
					setLoop: 2
					setCel: 0
					posn: 126 79
					setPri: 5
				)
				(arm2
					view: 321
					setLoop: 2
					setCel: 1
					posn: 173 84
					setPri: 5
				)
				(gLongSong2 stop:)
				(= seconds 2)
			)
			(11
				(proc0_14 320 21 67 -1 185 70 280)
				(gLongSong fade: 0 15 10 1)
				(gLongSong2 fade: 0 15 10 1)
				(global2 newRoom: 310)
			)
		)
	)
)

(instance sWakeUpVenice of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_13 310)
				(cloud hide:)
				(global2 drawPic: (global2 picture?))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= local2 56)
				(global2 overlay: 355)
				(dreamProp2
					init:
					view: 356
					setLoop: 0
					posn: 187 126
					cycleSpeed: 10
					setCel: 255
					setPri: 14
					setCycle: Beg self
				)
				(gLongSong
					number: 350
					loop: -1
					play: 60
					fade: 127 15 10 0
				)
				(proc0_2)
			)
			(1 (= ticks 60))
			(2
				(proc0_14 320 22 67 -1 15 70 280 108 self)
			)
			(3
				(gLongSong2
					number: 352
					loop: -1
					play: 60
					fade: 127 15 15 0
				)
				(= ticks 10)
			)
			(4
				(dreamProp1
					init:
					view: 355
					setLoop: 0
					setCycle: Fwd
					setPri: 14
					posn: 205 137
					signal: 18448
				)
				(= ticks 123)
			)
			(5
				(gLongSong2 fade: 0 15 5 1 self)
			)
			(6
				(= local1 0)
				(global2 drawPic: (global2 picture?))
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(magazine init:)
				)
				(cloud show:)
				(dreamProp1 dispose:)
				(dreamProp2 dispose:)
				(gLongSong number: 321 loop: -1 play:)
				(gLongSong2
					number: 346
					loop: 1
					play: 60
					fade: 127 15 10 0
				)
				(body
					init:
					view: 325
					loop: 0
					setCel: 0
					posn: 165 124
					setPri: 4
					stopUpd:
				)
				(arm
					init:
					view: 324
					setLoop: 0
					setCel: 2
					posn: 147 105
					setPri: 8
				)
				(arm2
					init:
					view: 324
					setLoop: 1
					setCel: 0
					posn: 169 82
					setPri: 6
				)
				(larry setPri: 5 startUpd:)
				(= ticks 10)
			)
			(7
				(arm2 cycleSpeed: 10 setCycle: End self)
			)
			(8
				(larry view: 324 setLoop: 0 setCel: 0 posn: 139 72)
				(= seconds 3)
			)
			(9
				(larry
					view: 325
					loop: 1
					setCel: 5
					posn: 134 70
					cycleSpeed: 17
					setCycle: CT 7 1 self
				)
			)
			(10 (= seconds 3))
			(11
				(proc0_14 320 23 67 -1 15 70 280 108 self)
			)
			(12 (= ticks 30))
			(13
				(proc0_14 320 21 67 -1 185 70 280)
				(gLongSong fade: 0 15 10 1)
				(gLongSong2 fade: 0 15 10 1)
				(= seconds 2)
			)
			(14 (global2 newRoom: 310))
		)
	)
)

(instance sDreamTaj of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(magazine dispose:)
				)
				(body dispose:)
				(arm dispose:)
				(tray dispose:)
				(cloud dispose:)
				(arm2 dispose:)
				(dreamProp1
					view: 370
					setLoop: 0
					setCycle: RandCycle
					posn: 72 122
					cycleSpeed: 8
					signal: 18448
				)
				(dreamProp2
					init:
					view: 370
					setLoop: 2
					posn: 155 80
					cycleSpeed: 3
					setCycle: RandCycle
				)
				(dreamProp3
					init:
					view: 370
					setLoop: 1
					setCycle: RandCycle
					cycleSpeed: 8
					posn: 236 112
				)
				(dreamProp4
					init:
					view: 370
					setLoop: 3
					setCycle: RandCycle
					cycleSpeed: 6
					posn: 126 88
				)
				(dreamProp5
					init:
					view: 370
					setLoop: 4
					setCycle: RandCycle
					cycleSpeed: 6
					posn: 193 94
				)
				(patti
					init:
					view: 371
					posn: 166 151
					setLoop: 0
					setCycle: Fwd
					cycleSpeed: 8
					setScript: sPlayGuitar
				)
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= local2 56)
				(global2 overlay: 370)
				(= seconds 3)
			)
			(1
				(proc0_14 320 24 108 self 67 -1 15 70 280)
			)
			(2 (= ticks 90))
			(3
				(gLongSong fade: 0 15 10 1)
				(gLongSong2 fade: 0 15 10 1)
				(= seconds 3)
			)
			(4 (= local1 0) (= cycles 2))
			(5 (global2 newRoom: 800))
		)
	)
)

(instance sWakeUpTaj of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_13 310)
				(cloud hide:)
				(global2 drawPic: (global2 picture?))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= local2 56)
				(global2 overlay: 375)
				(dreamProp1
					init:
					view: 376
					setLoop: 0
					setCel: 0
					posn: 170 137
					setPri: 14
					cycleSpeed: 10
				)
				(larry
					init:
					view: 376
					setLoop: 2
					posn: 170 137
					cycleSpeed: 10
					setPri: 13
					stopUpd:
				)
				(dreamProp2
					init:
					view: 375
					setLoop: 0
					posn: 197 141
					setPri: 15
				)
				(patti
					init:
					view: 377
					setLoop: 0
					posn: 226 135
					setPri: 14
					cycleSpeed: 10
				)
				(= ticks 10)
			)
			(1
				(proc0_2)
				(proc0_14 320 25 67 -1 15 70 280)
				(gLongSong2 number: 375 loop: -1 play:)
				(patti cycleSpeed: 10 setCycle: Fwd)
				(dreamProp2 cycleSpeed: 10 setCel: 0 setCycle: End self)
			)
			(2
				(dreamProp2 setLoop: 1 setCycle: MyForward)
				(= seconds 3)
			)
			(3
				(dreamProp1 setCel: 0 setCycle: End self)
			)
			(4
				(dreamProp1 setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(proc0_14 320 26 67 -1 15 70 280 108)
				(gLongSong2 fade: 0 15 12 1)
				(= seconds 4)
			)
			(6
				(= local1 0)
				(global2 drawPic: (global2 picture?))
				(body init: stopUpd:)
				(arm init:)
				(tray init:)
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(magazine init:)
				)
				(dreamProp1 dispose:)
				(dreamProp2 dispose:)
				(patti dispose:)
				(gLongSong number: 321 loop: -1 play:)
				(gLongSong2
					number: 346
					loop: 1
					play: 60
					fade: 127 15 10 0
				)
				(cloud show:)
				(tray init: cycleSpeed: 10 setCycle: End self)
				(larry init: view: 325 posn: 136 68 setLoop: 1 setCel: 0)
				(body init: view: 325 setLoop: 0 setCel: 0 stopUpd:)
				(arm
					init:
					view: 325
					setLoop: 2
					setCel: 1
					posn: 132 76
					setPri: 6
				)
				(arm2
					init:
					view: 325
					setLoop: 3
					setCel: 1
					setPri: 6
					posn: 183 56
				)
			)
			(7
				(larry setCel: 1 cycleSpeed: 10 setCycle: CT 5 1 self)
			)
			(8
				(larry setCel: 6 posn: 144 66)
				(body setCel: 1)
				(arm setCel: 2 posn: 129 78)
				(arm2 setCel: 2 posn: 170 60)
				(= ticks 30)
			)
			(9
				(arm setCel: 3 posn: 129 75)
				(larry setCel: 7 posn: 152 61)
				(body setCel: 2)
				(= seconds 3)
			)
			(10
				(proc0_14 320 21 67 -1 185 70 280)
				(proc0_14 320 27 67 -1 185 70 280)
				(gLongSong fade: 0 15 10 1)
				(gLongSong2 fade: 0 15 10 1)
				(= seconds 3)
			)
			(11 (global2 newRoom: 310))
		)
	)
)

(instance sDreamVenice of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(magazine dispose:)
				)
				(body dispose:)
				(arm dispose:)
				(tray dispose:)
				(cloud dispose:)
				(arm2 dispose:)
				(dreamProp1
					view: 350
					setLoop: 0
					posn: 216 93
					setPri: 12
					setCycle: Fwd
					cycleSpeed: 10
					signal: 18448
				)
				(dreamProp2
					init:
					view: 350
					setLoop: 1
					posn: 209 135
					setCycle: Fwd
					cycleSpeed: 10
					setPri: 12
					signal: 18448
				)
				(larry
					init:
					view: 351
					setLoop: 0
					setCel: 0
					posn: 297 77
					setPri: 13
					signal: 18448
				)
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= local2 56)
				(global2 overlay: 350)
				(= ticks 30)
			)
			(1
				(proc0_14 320 28 67 -1 185 70 280)
				(larry
					cycleSpeed: 8
					moveSpeed: 12
					setCycle: Fwd
					setMotion: MoveTo 285 83 self
				)
			)
			(2
				(larry setMotion: MoveTo 266 90 self)
			)
			(3
				(larry setMotion: MoveTo 255 96 self)
			)
			(4
				(larry setCel: 0)
				(= cycles 2)
			)
			(5
				(proc0_14 320 29 67 -1 20)
				(proc0_14 320 30 67 -1 185)
				(larry setLoop: 1 setCel: 0)
				(= ticks 30)
			)
			(6
				(gLongSong2 number: 351 loop: 1 play:)
				(larry setCel: 1)
				(dreamProp3
					init:
					view: 351
					setPri: 14
					setLoop: 2
					posn: 241 98
				)
				(= cycles 2)
			)
			(7
				(larry
					cycleSpeed: 20
					setCycle: End
					setMotion: MoveTo 145 143 self
				)
			)
			(8
				(if gTheNewDialog (gTheNewDialog dispose:))
				(dreamProp1 dispose:)
				(dreamProp2 dispose:)
				(patti dispose:)
				(global2 drawPic: (global2 picture?))
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= local2 56)
				(larry
					setMotion: 0
					view: 321
					setLoop: 1
					setCel: 1
					posn: 134 70
					setPri: 4
					addToPic:
					dispose:
				)
				(global2 overlay: 355)
				(dreamProp3
					init:
					view: 356
					setLoop: 0
					posn: 187 126
					cycleSpeed: 10
					setCel: 0
					setCycle: End self
				)
			)
			(9
				(proc0_14 320 31 67 -1 15 70 280)
				(= ticks 30)
			)
			(10
				(= local1 0)
				(gLongSong fade: 0 15 10 1)
				(gLongSong2 fade: 0 15 10 1)
				(= seconds 2)
			)
			(11 (global2 newRoom: 600))
		)
	)
)

(instance theMagazine of Feature
	(properties
		x 206
		y 202
		z 100
		nsTop 92
		nsLeft 196
		nsBottom 112
		nsRight 216
		description {the magazine}
		sightAngle 40
	)
	
	(method (doVerb)
		(magazine doVerb: &rest)
	)
)

(instance sDreamCasa of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if
				(and (not (proc0_6 52)) (not (gLarry has: 9)))
					(magazine dispose:)
				)
				(body dispose:)
				(arm dispose:)
				(tray dispose:)
				(cloud dispose:)
				(arm2 dispose:)
				(gLongSong2 number: 380 loop: -1 play:)
				(dreamProp1
					init:
					view: 380
					setLoop: 0
					posn: 228 47
					setPri: 14
					show:
					addToPic:
				)
				(dreamProp2
					init:
					view: 380
					setLoop: 1
					posn: 267 49
					setPri: 14
					show:
					addToPic:
				)
				(Graph grFILL_BOX 0 0 192 320 2 0 0)
				(= local2 56)
				(global2 overlay: 380)
				(= seconds 4)
			)
			(1
				(proc0_18 Leisure_Suit_Bogie 320 32 108 139 self)
			)
			(2 (= seconds 3))
			(3
				(proc0_18 Ingrid_Patti 320 33 108 139 self)
			)
			(4 (= seconds 3))
			(5
				(proc0_18 Ingrid_Patti 320 34 108 139 self)
			)
			(6 (= seconds 3))
			(7
				(proc0_18 Leisure_Suit_Bogie 320 35 108 139 self)
			)
			(8
				(gLongSong fade: 0 15 10 1)
				(= local1 0)
				(= ticks 10)
			)
			(9 (global2 newRoom: 380))
		)
	)
)

(instance Leisure_Suit_Bogie of Talker
	(properties
		x 1
		y 180
		nsTop 83
		nsLeft 125
		view 1381
		loop 1
		talkWidth 180
		name "Leisure Suit Bogie"
	)
	
	(method (init)
		(= mouth hisMouth)
		(super init:)
	)
)

(instance hisMouth of Prop
	(properties
		view 1381
	)
)

(instance Ingrid_Patti of Talker
	(properties
		x 140
		y 180
		nsTop 82
		nsLeft 169
		view 1382
		loop 1
		talkWidth 180
		name "Ingrid Patti"
	)
	
	(method (init)
		(= mouth herMouth)
		(super init:)
	)
)

(instance herMouth of Prop
	(properties
		view 1382
	)
)

(instance theMusic3 of Sound
	(properties
		number 322
	)
)

(instance zipperSound of Sound
	(properties
		number 347
	)
)

(instance sPlayGuitar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(dreamProp1 cycleSpeed: (Random 3 8))
				(dreamProp2 cycleSpeed: (Random 3 8))
				(dreamProp3 cycleSpeed: (Random 3 8))
				(dreamProp4 cycleSpeed: (Random 3 8))
				(dreamProp5 cycleSpeed: (Random 3 8))
				(patti setLoop: 0 cycleSpeed: (Random 3 8) setCycle: Fwd)
				(= ticks (Random 20 40))
			)
			(1
				(patti
					setLoop: 1
					cycleSpeed: (Random 3 8)
					setCycle: End self
				)
			)
			(2
				(patti setLoop: 2 cycleSpeed: (Random 3 8) setCycle: Fwd)
				(= ticks (Random 20 40))
			)
			(3
				(patti
					setLoop: 1
					cycleSpeed: (Random 3 8)
					setCycle: Beg self
				)
			)
			(4 (self init:))
		)
	)
)
